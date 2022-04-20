<template>
<div>
  <dash-board-page/>
  <dash-board-side-bar/>
</div>
</template>
<script>

import DashBoard from '@/components/DashBoard/DashBoard.vue'
import DashBoardSideBar from '@/components/DashBoard/DashBoardSideBar.vue'



export default {
  components: { 
    DashBoard,
    DashBoardSideBar
     },
    name : 'DashBoardPage.vue'
}
</script>
