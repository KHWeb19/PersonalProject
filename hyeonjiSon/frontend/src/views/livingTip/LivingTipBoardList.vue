<template>
<v-main>
   <v-data-iterator :items="tipBoards"
                  :items-per-page.sync="itemsPerPage"
                  >

                  <!-- sort-by: 파일별로 정렬 -->

      <template v-slot:header>
         <v-row>
               <v-text-field v-model="search" label="Search" append-icon="mdi-magnify" 
            solo hide-details></v-text-field>
            
            <v-btn @click="register">
            <v-icon>add</v-icon>
            </v-btn>
         </v-row>
      </template>

   <br>

      <template v-slot:default>
         <v-row>
            <v-col v-for="tipBoard in tipBoards"
                     :key="tipBoard.boardNo">
               <v-card @click="tipRead(tipBoard.boardNo)"
                     style="margin:10px; width: 250px; height: 300px;">              
               <v-toolbar dark>
                     <router-link :to="{ name: 'TipReadPage',
                                                params: { boardNo: tipBoard.boardNo.toString() } }">      
                  <v-toolbar-title>{{ tipBoard.title }}</v-toolbar-title>
                     </router-link>
               </v-toolbar>   

                     <v-card-text>{{ tipBoard.content }} </v-card-text>
                           <v-divider></v-divider>
               </v-card>
            </v-col>
         </v-row>
      </template>

   <br>

   </v-data-iterator>
</v-main>
</template>

<script>
//import TipBoardList from '@/components/livingTip/TipBoardList.vue'
import { mapState, mapActions } from 'vuex'

export default {
   name: 'LivingTipBoardList',
 //   props: {
 //       boardNo: {
 //           type: String,
  //          required: true
 //       }
  //  },   
   components: {
     // TipBoardList
   },
   data () {
      return {
         search: '',
         page: 1,
         itemsPerPage: 5,
         pages: [],
         sortBy: 'title',
         sortDesc: false,
}
   },
    computed: {
        ...mapState(['tipBoards']),
},
    mounted () {
        this.fetchTipBoardList()
    },
    methods: {
         ...mapActions(['fetchTipBoardList', 'fetchTipBoard']),
         register() {
            this.$router.push({ name:'tipRegisterPage' })
         }        
    }
}
</script>

<style scoped>
#search {
   width: 800px;
}
</style>