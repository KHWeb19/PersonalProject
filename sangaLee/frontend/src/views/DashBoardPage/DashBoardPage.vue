<template>
  <div class="mainbg">
    <v-navigation-drawer app fixed permanent :width="150">
      <side-bar/>
    </v-navigation-drawer>
      <dash-board/>
      <v-navigation-drawer app fixed permanent :width="350" right>
        <right-bar/>
      </v-navigation-drawer>

  </div>
  
</template>
<script>

import DashBoard from '@/components/DashBoard/DashBoard.vue'
import SideBar from '@/components/Layout/SideBar.vue'
import RightBar from '@/components/Layout/RightBar.vue'

export default {
  components: { 
    DashBoard,
    SideBar,
    RightBar,
     },
    name : 'DashBoardPage.vue'
}
</script>

<style scoped>
</style>