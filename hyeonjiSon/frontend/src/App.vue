<template>
  <v-app>
    <default-layout/>
      <v-main>
        <router-view/>
      </v-main>    
  </v-app>
</template>

<script>
import DefaultLayout from './views/DefaultLayout.vue'

export default {
  components: { DefaultLayout },
  name: 'App',
}

</script>
