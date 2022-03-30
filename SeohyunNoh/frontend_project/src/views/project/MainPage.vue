<template>
    <div>
        <v-toolbar dense dark>
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
            </v-app-bar-nav-icon>
            
            <!-- 로고 버튼 누르면 메인페이지로 이동하는거 구현하고 싶은데 모르겠음-->
             <v-toolbar-title class="text-uppercase grey--text">
                <v-icon left>
                    mdi-home
                </v-icon>
                <span>HOME</span>
            </v-toolbar-title>

            <v-spacer></v-spacer>

            <v-toolbar-items>
                <v-btn v-for="link in links" :key="link.icon" :to="link.route">
                    <v-icon left>
                        {{ link.icon }}
                    </v-icon>
                    <span> {{ link.text }}</span>
                </v-btn>
            </v-toolbar-items>
        </v-toolbar>

        <!-- <v-navigation-drawer app v-model="nav_drawer" temporary>
            <v-list nav dense>
                <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
                    <v-list-item-action>
                        <v-icon left>
                            {{ link.icon }}
                        </v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title>
                            {{ link.text}}
                        </v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list>
        </v-navigation-drawer> -->

    </div>
</template>

<script>
export default {
    data() {
        return {
          nav_drawer: false,
          links: [
              { icon: 'mdi-home', text: 'HOME', name: 'logo', route: '/mainPage' },
              { icon: 'mdi-login-variant', text: 'LOGIN', name: 'login', route: '/loginPage' },
              { icon: 'mdi-account-plus-outline', text: 'JOIN', name: 'join', route: '/joinPage' },
              { icon: 'mdi-cart', text: 'CART', name: 'cart', route: '/cartPage' }
          ]  
        }
    }
}
</script>