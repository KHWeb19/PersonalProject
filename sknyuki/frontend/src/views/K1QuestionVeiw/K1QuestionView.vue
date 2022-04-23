<template>
    <v-container>
        <header-view></header-view>
        <br>
        <drop-down></drop-down>
         <div id="board" align=center>
           
          <h3 style="padding:30px 0px 20px 0px; font-weight:bold">질문 게시판</h3>
          
          <div class="app">
        <question-board-list :BrandCheckboards="BrandCheckboards"/>
          </div>
         </div>
        
        


    </v-container>
</template>
<script>
import HeaderView from '@/components/home/headerView.vue'
import DropDown from '@/components/KategoriePage1/DropDown.vue'
import QuestionBoardList from '@/components/QuestionBoard/QuestionBoardList.vue'

export default {
    name:'K1QuestionView',
    components:{ 
    HeaderView,
    DropDown,
    QuestionBoardList,
        
   },
/* computed: {
        ...mapState(['BrandCheckboards'])
    },
    mounted () {
        this.fetchBoardList()
    },
    methods: {
        ...mapActions(['fetchBoardList'])
    }*/
    }
</script>

<style scoped>
.app {
  padding:0px 50px 100px 50px;
}
</style>