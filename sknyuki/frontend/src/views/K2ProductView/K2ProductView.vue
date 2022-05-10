<template>
<div>
    <v-container>
        <header-view></header-view>
        <br>
        <div id="board" align=center>
           
          <h3 style="padding:30px 0px 20px 0px; font-weight:bold">판매중인 상품</h3>
     

    <div class="app">
        <product-board-list v-if="isLogin" :ProductBoardSs="ProductBoardSs"/>
    
    
      <v-snackbar v-else v-model="login" :timeout="timeout" color="secondary" outlined
        bottom rounded="xl">
      <p>로그인 해주세요!!</p>
      <login-page></login-page>
    </v-snackbar>
</div>
</div>

    </v-container>
    <footer-view/>
</div>
</template>
<script>
import HeaderView from '@/components/home/headerView.vue'
import ProductBoardList from '@/components/ProductBoard/ProductBoardList.vue'
import { mapState, mapActions } from 'vuex'
import LoginPage from '@/views/member/LoginPage.vue'
import FooterView from '@/components/home/footerView.vue'

export default {
    name:'K2ProductView',
    components:{ 
    HeaderView,
    ProductBoardList,
    LoginPage,
        FooterView,
    },
    data() {
    return {
      login: true,
      timeout: 2000,
    }
    },
 computed: {
        ...mapState(['ProductBoardSs','isLogin'])
    },
    mounted () {
        this.fetchProductBoardsList()
    },
    methods: {
        ...mapActions(['fetchProductBoardsList'])
    }
    }
</script>

<style scoped>
.app {
  padding:0px 50px 100px 50px;
}
</style>