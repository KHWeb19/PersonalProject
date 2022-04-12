<template>
<div>
   <v-toolbar class="my-3 pt-3" color="primary" flat>
      <v-text-field v-model="search" label="Search" append-icon="mdi-magnify" 
      solo hide-details></v-text-field>
      
      <v-btn @click="register">
      <v-icon>add</v-icon>
      </v-btn>
   </v-toolbar>

    <v-container>
        <v-card>
           <v-row>
              <v-card-title v-if="!tipBoard || (Array.isArray(tipBoards) && tipBoards.length === 0)">
               현재 등록된 게시물이 없습니다!
              </v-card-title>

            <v-col v-else v-for="tipBoard in tipBoards" :key="tipBoard.boardNo">
               <v-card-title>{{tipBoard.title}}</v-card-title>
               <v-card-text>{{tipBoard.content}}</v-card-text>

                  <v-card-text class="card-text-id caption">
                    {{ item.id }}
                  </v-card-text>
                  <v-card-text class="card-text-date caption">
                    {{new Date(item.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(0, 11)}}
                  </v-card-text>
            </v-col>
           </v-row>
        </v-card>
    </v-container>


</div>
</template>

<script>

export default {
   name: 'LivingTipBoardList',
   props: {
      tipBoards: {
         type: Array
      }
   },
   mounted () {
      this.FETCH_TIP_BOARD_LIST()
   },
   methods: {
      register() {
         this.$router.push({ name: 'tipRegisterPage' })
      }
   },
}
</script>

<style scoped>

</style>