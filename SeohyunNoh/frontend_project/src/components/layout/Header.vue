<template>
<div id="app">
  <v-app id="inspire">
    <v-card color="basil">
        <v-card-title>
          <h1 class="font-weight-bold text-h2 basil--text" @click="mainPageLink">
            SELECTSHOP
          </h1>
        
          <v-spacer></v-spacer>

        <!-- 검색 네모창을 만들어야함 --> 
        <v-btn icon type="submit" color="basil">
          <v-icon>mdi-magnify</v-icon>
          <span></span>
           <v-input size="sm" class="mr-sm-2" placeholder="Search"></v-input>
        </v-btn>

        <!-- 로그인, 장바구니, 마이페이지 --> 
        <v-btn plain background-color="transparent" color="basil" v-for="link in links" :key="link.icon" :to="link.route">
            <v-icon left>
                {{ link.icon }}
            </v-icon>
            <span> {{ link.text }}</span>
        </v-btn>
      </v-card-title>

      <v-tabs v-model="tab" background-color="transparent" color="basil" grow>
        <v-tab v-for="menu in menus" :key="menu">
          {{ menu }}
        </v-tab>
      </v-tabs>
      <!-- <v-tabs-items v-model="tab">
        <v-tab-item v-for="menu in menus" :key="menu">
          <v-card color="basil" flat>
             <v-card-text>{{ text }}</v-card-text> 
          </v-card>
        </v-tab-item> 
      </v-tabs-items> -->
    </v-card>
  </v-app>
</div>
</template>

<script>

export default {
   data () {
        return {
            tab: null,
            menus: [
                'women', 'men', 'sale', 'lookbook'
            ],
            links: [
              { icon: 'mdi-login-variant', text: 'LOGIN', name: 'login', route: '/loginPage' },
              { icon: 'mdi-cart', text: 'CART', name: 'cart', route: '/cartPage' },
              { icon: 'mdi-account-cowboy-hat-outline', text: 'MYPAGE', name: 'myPage', route: '/myPage' }
          ]
        }

    },
    methods: {
        mainPageLink() {
            this.$router.push({ path: '/mainPage' })
        }
    }
}
</script>

<style scoped>
  
</style>