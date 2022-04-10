<template>
      <v-card color="basil">
          <v-card-title>
            <h1 class="font-weight-bold text-h2 basil--text" @click="mainPageLink">
              SELECTSHOP
            </h1>
          
            <v-spacer></v-spacer>

          <!-- 검색 네모창을 만들어야함 --> 
          <!-- <v-btn icon type="submit" color="basil">
             <v-icon>mdi-magnify</v-icon>
            <span></span>
            <v-input type="text" size="sm" class="mr-sm-2" placeholder="Search">search</v-input> 
            <v-text-field hidden-details flat label="Search" prepend-inner-icon="mdi-magnify" solo-inverted></v-text-field>
          </v-btn> 
          
          <v-container>
    <v-text-field v-model="search" single-line></v-text-field>
    <v-data-table
            style="width: 50%"
            :headers="headers"
            :items="contents"
            :items-per-page="5"
            :search="search"
    ></v-data-table>
  </v-container>
          -->

          <!-- 로그인, 장바구니, 마이페이지, 게시판--> 
            <v-btn v-if="this.$store.state.userInfo == null" router :to="{path: '/loginPage'}" plain background-color="transparent" color="basil"> 
              LOGIN 
            </v-btn>
            <v-btn v-else @click="logout"  plain background-color="transparent" color="basil"> 
              LOGOUT 
            </v-btn>


            <v-btn router :to="{path: '/myPage'}" plain background-color="transparent" color="basil">
              MY PAGE
            </v-btn>     
          
            

          <!-- 그 중 게시판(BOARD)을 클릭하면 드롭다운으로 공지사항, 1:1문의 페이지로 이동하게 --> 
            <v-menu open-on-hover bottom offset-y>
              <template v-slot:activator="{ on, attrs }">
                <v-btn plain background-color="transparent" color="basil" v-bind="attrs" v-on="on">
                  <v-icon left>
                    mdi-view-dashboard-edit-outline
                  </v-icon>
                  <span> BOARD </span>
                </v-btn>
              </template>

              <v-list background-color="transparent" color="basil">
                <v-list-item v-for="(board, i) in boards" :key="i" :to="board.route">
                  <v-list-item-title>
                    {{ board.text }}
                  </v-list-item-title>
                </v-list-item>
              </v-list>
            </v-menu>
              
          </v-card-title>

        <!-- 카테고리 메뉴 탭 (코드 너무 지저분하다 리팩토링 필요한데 v-btn에 v-for적용하면 women이랑 men이랑 같이 나옴) --> 
          <v-tabs v-model="tab" background-color="transparent" color="basil" grow>
            <v-tab>
              <v-menu open-on-hover bottom offset-y>
                <template v-slot:activator="{ on, attrs }">
                  <v-btn plain background-color="transparent" color="basil" v-bind="attrs" v-on="on">
                    WOMEN
                  </v-btn>
                </template>

                <v-list background-color="transparent" color="basil">
                  <v-list-item v-for="(category, i) in womenCategories" :key="i">
                    <v-list-item-title>
                      {{ category.item }}
                    </v-list-item-title>
                  </v-list-item>
                </v-list>
              </v-menu>
            </v-tab>

            <v-tab>
              <v-menu open-on-hover bottom offset-y>
                <template v-slot:activator="{ on, attrs }">
                  <v-btn plain background-color="transparent" color="basil" v-bind="attrs" v-on="on">
                    MEN
                  </v-btn>
                </template>

                <v-list background-color="transparent" color="basil">
                  <v-list-item v-for="(category, i) in menCategories" :key="i">
                    <v-list-item-title>
                      {{ category.item }}
                    </v-list-item-title>
                  </v-list-item>
                </v-list> 
            </v-menu>
            </v-tab>


             <v-tab>
              <v-menu open-on-hover bottom offset-y>
                <template v-slot:activator="{ on, attrs }">
                  <v-btn plain background-color="transparent" color="basil" v-bind="attrs" v-on="on" router :to="{path: '/lookbookPage'}">
                    LOOKBOOK
                  </v-btn>
                </template>
              </v-menu>
            </v-tab>
          </v-tabs>
        

      </v-card>
</template>

<script>

import { mapGetters } from 'vuex'

export default {
   data () {
        return {
            tab: null,
            isLogin: false,
            menus: [
               'women', 'men'
            ],
            links: [
              { icon: 'mdi-login-variant', text: 'LOGIN', name: 'login', route: '/loginPage' },
              { icon: 'mdi-cart', text: 'CART', name: 'cart', route: '/cartPage' },
              { icon: 'mdi-account-cowboy-hat-outline', text: 'MYPAGE', name: 'myPage', route: '/myPage' },
            ],
            boards: [
              {text: '1:1 문의', name: 'inquiry', route: '/inquiryPage'},
              {text: 'NOTICE', name: 'notice', route: '/noticePage'}
            ],
            womenCategories: [
              { item: 'Outer'},
              { item: 'Top'},
              { item: 'Bottom'},
              { item: 'Accessories'},
            ],
            menCategories: [
              { item: 'Outer'},
              { item: 'Top'},
              { item: 'Bottom'},
              { item: 'Accessories'},
            ]
        }

    },
    computed: {
      ...mapGetters(['loggedIn'])
    },
    methods: {
        mainPageLink() {
            this.$router.push({ path: '/mainPage' })
        },
        logout() {
          this.$store.dispatch('logout')
        }
    }
}
</script>

<style scoped>
  
</style>