<template>
  <div class="home">
    <router-link style="text-decoration: none;" :to="{name: 'HomeView'}">
      &nbsp;Home&nbsp;
    </router-link>
    <router-link style="text-decoration: none;" :to="{name: 'LoginPage'}">
      &nbsp;Login&nbsp;
    </router-link>
    <router-link style="text-decoration: none;" :to="{name: 'RegisterPage'}">
      &nbsp;Register&nbsp;
    </router-link>

  </div>
</template>

<script>


export default {
  name: 'Home',
  components: {

  }
}
</script>
