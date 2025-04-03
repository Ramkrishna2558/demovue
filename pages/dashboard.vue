<template >
  <div class="container mx-auto mt-6 ">
    <h2 class="text-2xl font-bold text-center text-[#265bff] mb-4">DASHBOARD</h2>

    <div class="flex justify-center space-x-3 mb-4 rounded-lg shadow-lg pb-2">
      <button class="px-4 py-2 bg-[#26b0ff] text-white rounded" @click="loadUsers">Refresh Users</button>
      <NuxtLink to="/createUser" class="btn px-4 py-2 bg-[#2686ff] text-white rounded">Add User</NuxtLink>
      <button class="px-4 py-2 bg-[#265bff] text-white rounded" @click="logout">Logout</button>
    </div>

    <div class="overflow-x-auto px-6 ">
      <table class="w-full border-collapse border shadow-xl rounded border-gray-300">
        <thead class="bg-[#2630ff] text-white">
          <tr>
            <th class="border p-2">ID</th>
            <th class="border p-2">Username</th>
            <th class="border p-2">Email</th>
            <th class="border p-2">Actions</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="user in users" :key="user.id" class="border bg-[#6ebaff] text-[#ffff]">
             <!-- user id  -->
            <td class="border p-2 text-center">{{ user.id }}</td>
            <!-- user name  -->
            <td class="border p-2">
              <input v-if="editUserId === user.id" v-model="editedUser.name" class="border p-1" />
              <span v-else>{{ user.name }}</span>
            </td>
            <!-- user email  -->
            <td class="border p-2">
              <input v-if="editUserId === user.id" v-model="editedUser.email" class="border p-1" />
              <span v-else>{{ user.email }}</span>
            </td>
            <!-- edit user template  -->
            <td class="border p-2 text-center">
              <template v-if="editUserId === user.id">
                <button class="bg-[#ffff] text-[#265bff] px-2 py-1 rounded mr-2" @click="saveUser(user.id)">Save</button>
                <button class="bg-[#265bff] border-2 border-white text-white px-2 py-1 rounded" @click="cancelEdit">Cancel</button>
              </template>
              <!-- else default user  -->
              <template v-else>
                <button class="bg-[#ffff] text-[#265bff] px-2 py-1 rounded mr-2" @click="editUser(user)">Edit</button>
                <button class="bg-[#265bff] text-white px-2 py-1 rounded" @click="deleteUser(user.id)">Delete</button>
              </template>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { useRouter } from 'nuxt/app';

const router = useRouter();
const users = ref([]);
const editUserId = ref(null);
const editedUser = ref({ username: '', email: '' });

onMounted(() => {
  loadUsers();
});

const loadUsers = async () => {
  try {
    const token = localStorage.getItem('token');
    if (!token) {
      alert('Unauthorized! Please login.');
      router.push('/login');
      return;
    }

    const response = await axios.get('http://localhost:8080/api/users', {
      headers: { Authorization: `Bearer ${token}` },
    });

    users.value = response.data;
  } catch (error) {
    console.error('Error loading users', error);
  }
};

const editUser = (user) => {
  editUserId.value = user.id;
  editedUser.value = { username: user.username, email: user.email };
};

const cancelEdit = () => {
  editUserId.value = null;
  editedUser.value = { username: '', email: '' };
};

const saveUser = async (userId) => {
  try {
    const token = localStorage.getItem('token');
    await axios.put(`http://localhost:8080/api/users/${userId}`, editedUser.value, {
      headers: { Authorization: `Bearer ${token}` },
    });

    loadUsers();
    cancelEdit();
  } catch (error) {
    console.error('Error updating user', error);
  }
};

const deleteUser = async (userId) => {
  if (!confirm('Are you sure you want to delete this user?')) return;
  try {
    const token = localStorage.getItem('token');
    await axios.delete(`http://localhost:8080/api/users/${userId}`, {
      headers: { Authorization: `Bearer ${token}` },
    });

    loadUsers();
  } catch (error) {
    console.error('Error deleting user', error);
  }
};

const logout = () => {
  localStorage.removeItem('token');
  router.push('/login');
};

const addUser = () => {
  router.push('/add-user');
};
</script>
