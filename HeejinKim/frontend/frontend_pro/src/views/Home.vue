<template>
  <div class="home">
      <main-page/>
    <div id="header">
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'
import MainPage from '@/views/main/MainPage.vue'

export default {
  name: 'Home',
  components: {
    MainPage
  }
}
</script>
