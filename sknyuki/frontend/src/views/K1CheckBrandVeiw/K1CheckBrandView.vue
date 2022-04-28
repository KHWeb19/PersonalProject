<template>
    <v-container>
        <header-view></header-view>
        <br>
        <div id="board" align=center>
           
          <h3 style="padding:30px 0px 20px 0px; font-weight:bold">판별 게시판</h3>
     

    <div class="app">
        <k-1-check-brand-list v-if="isLogin" :BrandCheckBoards="BrandCheckBoards" :brand="brand"/>
        <!--<h2 v-else> 로그인 해주세요</h2>-->
        
         <v-snackbar v-else v-model="login" :timeout="timeout" color="secondary" outlined
        bottom rounded="xl">
      <p>로그인 해주세요!!</p>
      <login-page></login-page>
    </v-snackbar>

    </div>
    </div>
     


    </v-container>
</template>
<script>
import { mapActions, mapState } from 'vuex'
import HeaderView from '@/components/home/headerView.vue'
import K1CheckBrandList from '@/components/BrandCheckBoard/K1CheckBrandList.vue'
import LoginPage from '@/views/member/LoginPage.vue'

export default {
    name:'K1CheckBrandView',
    components:{ 
    HeaderView,
    K1CheckBrandList,
    LoginPage,
    },
    props:{
      brand: {
        type: String}
    },
     data() {
    return {
      login: true,
      timeout: 2000,
    }
  },
    computed: {
        ...mapState(['BrandCheckBoards','isLogin'])
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