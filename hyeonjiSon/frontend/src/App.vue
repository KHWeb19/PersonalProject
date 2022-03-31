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

//App Bar는 모든 화면에 공통적으로 들어가는 main frame이기 때문에,
//해당 로직은 모두 App.vue에 구성합니다.

</script>
