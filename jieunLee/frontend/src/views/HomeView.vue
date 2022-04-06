<template>
  <div>
    <menu-bar/>
    <router-link style="text-decoration: none;" :to="{name: 'LoginPage'}">
      &nbsp;Login&nbsp;
    </router-link>
    <router-link style="text-decoration: none;" :to="{name: 'RegisterPage'}">
      &nbsp;Register&nbsp;
    </router-link>

  </div>
</template>

<script>
import MenuBar from '../components/MenuBar.vue'

export default {
  components: {
    MenuBar
  }
}
</script>

<style>


</style>