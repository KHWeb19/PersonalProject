<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/signup">SignUp</router-link> |
      <router-link to="/dummy">Dummy</router-link>
      <router-link to="myaccount" v-if="isLoggedIn">| Sign Out</router-link>
      <router-link to="login" v-else>| Log In</router-link>
      <router-view></router-view>
    </nav>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>

<script>
import {mapState} from "vuex"

export default{
  computed:{
    ...mapState(['isLoggedIn'])
  }
}

</script>
