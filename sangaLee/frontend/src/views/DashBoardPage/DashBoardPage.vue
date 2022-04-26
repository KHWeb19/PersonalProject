<template>
  <div class="mainbg">
    <v-navigation-drawer app fixed permanent :width="300">
      <side-bar/>
    </v-navigation-drawer>
      <dash-board/>
  </div>
  
</template>
<script>

import DashBoard from '@/components/DashBoard/DashBoard.vue'
import SideBar from '@/components/Layout/SideBar.vue'

export default {
  components: { 
    DashBoard,
    SideBar
     },
    name : 'DashBoardPage.vue'
}
</script>

<style scoped>
.mainbg {
  background-color: #EBECF0;
  height: 100vh;
}
</style>