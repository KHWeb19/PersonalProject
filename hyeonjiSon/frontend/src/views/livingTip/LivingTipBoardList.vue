<template>
<div class="board_wrap">

   <v-container  v-if="this.$store.state.userInfo == null">
      <br>
      <v-row>
         &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
         <img src="@/assets/join.jpg"/>
      </v-row>

   </v-container>
<v-container v-if="this.$store.state.userInfo != null">
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
         keyWord: '',
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