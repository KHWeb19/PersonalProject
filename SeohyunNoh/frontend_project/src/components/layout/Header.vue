<template>
      <v-card color="basil">
          <v-card-title>
            <h1 class="font-weight-bold text-h2 basil--text" @click="mainPageLink">
              SELECTSHOP
            </h1>
          
            <v-spacer></v-spacer>

          <!-- 검색 네모창을 만들어야함 --> 
          <v-btn icon type="submit" color="basil">
            <!-- <v-icon>mdi-magnify</v-icon>
            <span></span>
            <v-input type="text" size="sm" class="mr-sm-2" placeholder="Search">search</v-input> -->
            <v-text-field hidden-details flat label="Search" prepend-inner-icon="mdi-magnify" solo-inverted></v-text-field>
          </v-btn>

          <!-- 로그인, 장바구니, 마이페이지 --> 
           <v-btn plain background-color="transparent" color="basil" v-for="link in links" :key="link.icon" :to="link.route">
                <v-icon left>
                    {{ link.icon }}
                </v-icon>
                <span> {{ link.text }}</span>
            </v-btn>

            <v-menu>
              <template v-slot:activator="{ on, attrs }">
                <v-btn text v-bind="attrs" v-on="on">
                  {{ link.text.BOARD }}
                </v-btn>
                
                <v-list>
                  <v-list-item v-for="board in boards" :key="board" :to="board.route">
                    {{ board.text }}
                  </v-list-item>
                </v-list>
              </template>
            </v-menu>
  

        </v-card-title>

       <template>
        <v-tabs v-model="tab" background-color="transparent" color="basil" grow>
          <v-tab v-for="menu in menus" :key="menu">
            {{ menu }}
          </v-tab>

          <v-menu>
            <template v-slot:activator="{ on, attrs }">
              <v-btn text v-bind="attrs" v-on="on">
                {{ menu }}
              </v-btn>
            </template>

            <v-list>
              <v-list-item v-for="category in categories" :key="category">
                {{ category.item }}
              </v-list-item>
            </v-list>
          </v-menu>
        </v-tabs>
        
      </template>

      </v-card>
</template>

<script>

export default {
   data () {
        return {
            tab: null,
            menus: [
               'women', 'men','lookbook'
            ],
            links: [
              { icon: 'mdi-login-variant', text: 'LOGIN', name: 'login', route: '/loginPage' },
              { icon: 'mdi-cart', text: 'CART', name: 'cart', route: '/cartPage' },
              { icon: 'mdi-account-cowboy-hat-outline', text: 'MYPAGE', name: 'myPage', route: '/myPage' },
              { icon: 'mdi-view-dashboard-edit-outline', text: 'BOARD', name: 'myPage', route: '/boardPage' }
          ],
          boards: [
            {text: '1:1 문의', name: 'inquiry', route: '/inquiryPage'},
            {text: 'NOTICE', name: 'notice', route: '/noticePage'}
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