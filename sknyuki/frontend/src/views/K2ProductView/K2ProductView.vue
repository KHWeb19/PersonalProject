<template>
    <v-container>
        <header-view></header-view>
        <br>
        <div id="board" align=center>
           
          <h3 style="padding:30px 0px 20px 0px; font-weight:bold">판매중인 상품</h3>
     

    <div class="app">
        <product-board-list :productBoards="productBoards"/>
    </div>
    </div>
     


    </v-container>
</template>
<script>
import HeaderView from '@/components/home/headerView.vue'
import ProductBoardList from '@/components/ProductBoard/ProductBoardList.vue'
//import { mapState, mapActions } from 'vuex'

export default {
    name:'K2ProductView',
    components:{ 
    HeaderView,
    ProductBoardList,
        
    },
/* computed: {
        ...mapState(['productBoards'])
    },
    mounted () {
        this.fetchproductBoards()
    },
    methods: {
        ...mapActions(['fetchproductBoards'])
    }*/
    }
</script>

<style scoped>
.app {
  padding:0px 50px 100px 50px;
}
</style>