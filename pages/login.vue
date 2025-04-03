<template>
  <div class="flex flex-col items-center justify-center h-screen bg-[#2e85ff]"> 
    <form action="" @submit.prevent="login" class="flex flex-col border-3 border-white px-6 bg-[#6998ff] py-5 rounded items-center justify-center">
      <h1 class="text-2xl font-bold mb-4 text-[#ffff]">LOGIN</h1>
      <input type="text" class="border-1 rounded p-2 bg-[#cbd4ff] text-[#8fabff]" v-model="username" name="username" id="username" placeholder="Username"><br/>
      <input type="password" class="border-1 rounded p-2 bg-[#cbd4ff] text-[#8fabff]" v-model="password" name="password" id="password" placeholder="Password"><br/>
<div class="button flex gap-2">
  <button class="border-2 rounded border-white px-4 text-[#ffff] py-2 bg-[#2630ff]" type="submit">Get me in</button>
  <NuxtLink to="/createUser" class="border-2 rounded border-white px-4 text-[#ffff] py-2 bg-[#2630ff]">Register</NuxtLink>

</div>    </form>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue';
import axios from 'axios';

const username = ref('');
const password = ref('');
const URL = 'http://localhost:8080/auth/login';
const router = useRouter();
const login = async () => {
  try {
    const values = {
      email: username.value,
      password: password.value
    };
    const res = await axios.post(URL, values);
    console.log('Full login response:', res);
    const token = res.data;
    if (token && typeof token === 'string') {
      localStorage.setItem('token', token);
      console.log('Login successful:', token);
      router.push('/dashboard');
    } else {
      console.log('Login failed:', res);
    }
  } catch (err) {
    console.log('Login error:', err);
  }
}
</script>