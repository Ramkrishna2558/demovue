<template>
  <div class="container mt-5 d-flex justify-content-center justify-center ">
    <div class="bg-white p-6 shadow-lg rounded-lg w-full max-w-md mx-100">
      <h2 class="text-2xl font-semibold text-center mb-4">Add/Register User</h2>
      <form @submit.prevent="submitForm">
      <input
        v-model="user.name"
        type="text"
        class="border border-gray-300 rounded w-full py-2 px-3 mb-3 focus:outline-none focus:ring-2 focus:ring-blue-400"
        placeholder="Name"
        required
      />
      <input
        v-model="user.email"
        type="email"
        class="border border-gray-300 rounded w-full py-2 px-3 mb-3 focus:outline-none focus:ring-2 focus:ring-blue-400"
        placeholder="Email"
        required
      />
      <input
        v-model="user.password"
        type="password"
        class="border border-gray-300 rounded w-full py-2 px-3 mb-3 focus:outline-none focus:ring-2 focus:ring-blue-400"
        placeholder="Password"
        required
      />
      <button
        class="bg-blue-500 hover:bg-blue-600 text-white rounded w-full py-2"
        :disabled="isLoading"
      >
        Save
      </button>
      <button
        type="button"
        class="mt-2 bg-gray-500 hover:bg-gray-600 text-white rounded w-full py-2"
        @click="goBack"
      >
        Cancel
      </button>
      </form>
      <p v-if="message" class="text-green-500 text-center mt-2">{{ message }}</p>
      <p v-if="error" class="text-red-500 text-center mt-2">{{ error }}</p>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'; import { useRouter } from 'vue-router';
import axios from 'axios';

const user = ref({ name: '', email: '', password: '' });
const isLoading = ref(false), message = ref(''), error = ref('');
const router = useRouter();

const submitForm = async () => {
  isLoading.value = true; message.value = ''; error.value = '';
  try {
    const res = await axios.post('http://localhost:8080/auth/register', user.value);
    if (res.id === null) throw new Error('Failed to add user');
    message.value = 'User added!'; user.value = { name: '', email: '', password: '' };
  } catch (err) { error.value = err.message; } finally { isLoading.value = false; }
};

const goBack = () => router.push('/dashboard');
</script>
