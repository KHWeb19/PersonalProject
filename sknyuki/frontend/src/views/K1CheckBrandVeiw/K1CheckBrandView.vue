<template>
    <v-container>
        <header-view></header-view>
        <br>
        <drop-down></drop-down>
        <div id="board" align=center>
           
          <h3 style="padding:30px 0px 20px 0px; font-weight:bold">판별 게시판</h3>
     

    <div class="app">
        <k-1-check-brand-list :BrandCheckBoards="BrandCheckBoards"/>
    </div>
    </div>
     


    </v-container>
</template>
<script>
import { mapActions, mapState } from 'vuex'
import HeaderView from '@/components/home/headerView.vue'
import DropDown from '@/components/KategoriePage1/DropDown.vue'
import K1CheckBrandList from '@/components/BrandCheckBoard/K1CheckBrandList.vue'

export default {
    name:'K1CheckBrandView',
    components:{ 
    HeaderView,
    DropDown,
    K1CheckBrandList,
    },
    computed: {
        ...mapState(['BrandCheckBoards'])
    },
    mounted () {
        this.fetchBrandCheckBoardList()
    },
    methods: {
        ...mapActions(['fetchBrandCheckBoardList'])
    }
}

</script>

<style scoped>
.app {
  padding:0px 50px 100px 50px;
}
</style>