<template>    
    <section>
    <div>
        
        <router-link style="text-decoration: none; color:white;" 
            :to="{ name: 'HomeView' }">
            <h1>AKMU</h1>
        </router-link>
        
         <v-toolbar class="transparent" dense dark>
                <v-spacer></v-spacer>
                <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
                </v-app-bar-nav-icon> 
        </v-toolbar>

            <v-navigation-drawer app v-model="nav_drawer" src="" right temporary>
            <v-list nav dense>
                <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
                    <v-list-item-action>
                        <v-icon left>
                            {{ link.icon }}
                        </v-icon>
                    </v-list-item-action>
                    <v-list-item-content>
                        <v-list-item-title>
                            {{ link.text }}
                        </v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list>
        </v-navigation-drawer>
    </div>
    </section>
</template>

<script>
export default {
    name: 'NavBar',
    methods: {
    
      
    },
     data() {
        return{
            nav_drawer: false,
            links: [
                { icon: 'mdi-home', text: 'Home', name: 'HomeView', route: '/' },
                { icon: 'mdi-pencil-plus-outline', text:'자유게시판', name:'FreeBoardListPage', route:'/freeBoardList'},
                { icon: 'mdi-image-multiple', text: '사진게시판', name: 'PhotoBoardListPage', route: '/photoBoardList'}
            ],
     
        }
    }
}
</script>

<style scoped>
   
    section{
        background-image: url(@/assets/img/homeBackground.png);
        background-size: cover;
        background-repeat: no-repeat;
        display: block;
        height: 400px;
        color:#ffffff;
        text-align: center;
         
     }
    section h1{
        font-size: 2.5em;
        padding:  140px;
        
    }
    
</style>