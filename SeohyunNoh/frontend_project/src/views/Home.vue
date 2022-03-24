<template>
  <div id="header">
      <router-link style="text-decoration: none;" :to="{ name: 'Home' }">
        &nbsp;메인페이지 입장&nbsp;
      </router-link>
  </div>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {

  }
}
</script>
