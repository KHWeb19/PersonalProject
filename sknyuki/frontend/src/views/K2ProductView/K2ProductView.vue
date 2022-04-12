<template>
    <v-container>
        <header-view></header-view>
        <br>
        <drop-down></drop-down>
        <div id="board" align=center>
           
          <h3 style="padding:30px 0px 20px 0px; font-weight:bold">판매중인 상품</h3>
     

    <div class="app">
        <product-board-list :BrandCheckboards="BrandCheckboards"/>
    </div>
    </div>
     


    </v-container>
</template>
<script>
import HeaderView from '@/components/home/headerView.vue'
import DropDown from '@/components/KategoriePage1/DropDown.vue'
import ProductBoardList from '@/components/ProductBoard/ProductBoardList.vue'
//import { mapState, mapActions } from 'vuex'

export default {
    name:'K2ProductView',
    components:{ 
    HeaderView,
    DropDown,
    ProductBoardList,
        
    },
/* computed: {
        ...mapState(['BrandCheckboards'])
    },
    mounted () {
        this.fetchBrandCheckboards()
    },
    methods: {
        ...mapActions(['fetchBrandCheckboards'])
    }*/
    }
</script>

<style scoped>
.app {
  padding:0px 50px 100px 50px;
}
</style>