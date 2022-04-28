<template>
<v-container>
  
     <header-view></header-view>
   <v-card>
    <v-row>
      <v-col >
        <read-info></read-info>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <recent-board></recent-board>

      </v-col>
    </v-row>
      
    
  </v-card>
</v-container>
</template>


<script>
import HeaderView from '@/components/home/headerView.vue'
import ReadInfo from '@/components/member/ReadInfo'
import RecentBoard from '@/components/member/RecentBoard'


export default {
  name:'MyPage',
  components: {
    HeaderView,
    ReadInfo,
    RecentBoard
  }
}
</script>