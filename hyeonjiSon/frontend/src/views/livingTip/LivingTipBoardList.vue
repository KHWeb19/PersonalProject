<template>
<div class="board_wrap">
<v-container>
         <v-row>
               <v-text-field v-model="search" label="Search" append-icon="mdi-magnify" 
            solo hide-details></v-text-field>
            
            <v-btn @click="register">
            <v-icon>add</v-icon>
            </v-btn>
         </v-row>

   <br>

         <tip-board-list :tipBoards="tipBoards"
                          :list-array="pageArray"/>
   <br>

</v-container>
</div>
</template>

<script>
import TipBoardList from '@/components/livingTip/TipBoardList.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios';

export default {
   name: 'LivingTipBoardList',  
   components: {
      TipBoardList
   },
   data () {
      return {
         search: '',
         pageArray: [],
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
    },
    created() {
      axios
         .get("http://localhost:7777/tipboard/getTipBoardList")
         .then((res) => {
         this.pageArray = res.data;
         })
         .catch((err) => {
         console.log(err);
      });
  }
}
</script>

<style scoped>
#search {
   width: 800px;
}
</style>