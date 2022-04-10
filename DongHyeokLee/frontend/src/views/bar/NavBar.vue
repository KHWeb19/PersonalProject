<template>    
    <section>
        <div>
            <v-app-bar-nav-icon class="list" @click="nav_drawer = !nav_drawer" dense dark>
            </v-app-bar-nav-icon> 
            
            <v-navigation-drawer app v-model="nav_drawer" right temporary>
                <v-list nav dense>
                    <v-list-item v-for="link in links" :key="link.name" :href="link.route">
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
                { icon: 'mdi-pencil-plus-outline', text:'자유게시판', name:'FreeBoardListPage', route:'https://www.instagram.com/akmu_suhyun/'},
                { icon: 'mdi-image-multiple', text: '사진게시판', name: 'PhotoBoardListPage', route: '/photoBoardList'},
                { icon: 'mdi-music', text: 'playList', name: 'MusicPlayer', route: '/playList'},
                { icon: 'mdi-video', text: '영상게시판', name: 'VideoBoardListPage', route: '/videoBoardList'}
            ],
     
        }
    }
}
</script>

<style scoped>
   
   

    
 
</style>