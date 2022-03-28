<template>
    <div>
        <v-toolbar dense dark>
            <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
            </v-app-bar-nav-icon>
            <v-toolbar-title>
                <span class="font-weight-light">929SHOP</span>
            </v-toolbar-title>
            <v-toolbar-items>
                <v-btn text v-for="link in links" :key="link.icon" :to="link.route">
                    {{ link.text }}
                </v-btn>
            </v-toolbar-items>
        </v-toolbar>

        <v-navigation-drawer app v-model="nav_drawer" temporary>
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
        </v-navigation-drawer>

    </div>
</template>

<script>
export default {
    data() {
        return {
          nav_drawer: false,
          links: [
              { icon: 'mdi-home', text: 'Home', name: 'home', route: '/' },
              { icon: 'mdi-account', text: '로그인', name: 'login', route: '/logInPage' },
              { icon: 'mdi-cart', text: '장바구니', name: 'cart', route: '/cartPage' }
          ]  
        }
    }
}
</script>