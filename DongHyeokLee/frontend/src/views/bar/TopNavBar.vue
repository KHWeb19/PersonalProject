<template>
    <div class="header">

       
        <v-toolbar class="black" dense dark>
        <!-- 홈 -->
        <div>
            <router-link  id="home" :to="{ name: 'HomeView' }">
                <v-icon>
                    mdi-home
                </v-icon>
            </router-link>  
        </div>
        <!-- 자유게시판 -->
        <div>
            <router-link id="free-board" :to="{ name: 'FreeBoardListPage' }">
                BOARD
            </router-link>
        </div>
        <!-- 사진 게시판 -->
         <div>
            <router-link id="photo-board" :to="{ name: 'PhotoBoardListPage' }">
                PHOTO
            </router-link>
        </div>
        <!-- 영상 게시판 -->
          <div>
            <router-link id="video-board" :to="{ name: 'VideoBoardListPage' }">
                VIDEO
            </router-link>
        </div>
         <!-- 뮤직 플레이어 -->
          <div>
            <router-link id="music" :to="{ name: 'PlayListPage' }">
                <v-icon>
                    mdi-music
                </v-icon>
                MUSIC
            </router-link>
        </div>
        <!-- 멤버 관리 -->
            <v-spacer></v-spacer>
        <div id="login" v-if="!this.$store.state.isLogin" > 
             <!-- 회원가입, 로그인-->
            <v-toolbar-title>         
                <member-sign-up/>
                <member-login/>
            </v-toolbar-title>
        </div>
            
        <div id="logout" v-if="this.$store.state.isLogin">
            <!-- 로그아웃, 마이페이지 -->
            <v-toolbar-title>         
                <member-my-page/>
                <member-logout/>
            </v-toolbar-title>
        </div>
        
        <div>
            <v-app-bar-nav-icon  @click="nav_drawer = !nav_drawer" dense dark>
            </v-app-bar-nav-icon> 
             <v-navigation-drawer  class="list" app v-model="nav_drawer" right temporary>
                <v-list nav dense>
                    <v-list-item v-for="(link, index) in links" :key="index" :href="link.route">
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
 

    
        </v-toolbar>
        
    </div>
</template>

<script>

import MemberSignUp from '@/views/member/MemberSignUp.vue'
import MemberLogin from '@/views/member/MemberLogin.vue'
import MemberLogout from '@/views/member/MemberLogout.vue'
import MemberMyPage from '@/views/member/MemberMyPage.vue'


export default {  
    name: 'TopNavBar',
    components: {
        MemberSignUp,
        MemberLogin,
        MemberLogout,
        MemberMyPage
     
    },
    data () {
        return {
             nav_drawer: false,
             links: [
                { icon: 'mdi-instagram', text: 'SU-HYUN', route: 'https://www.instagram.com/akmu_suhyun/' },
                { icon: 'mdi-instagram', text:'CHAN-HYEOK',  route:'https://www.instagram.com/akmuchanhk/'},
                { icon: 'mdi-youtube', text:'SU-HYUN', route:'https://www.youtube.com/c/Leesuhyun'},
                { icon: 'mdi-youtube', text:'AKMU', route:'https://www.youtube.com/c/officialAKMU'},
            ],
     
        }
    }
}
</script>


<style scoped>
a{
    text-decoration: none;
    
}
a:hover{
    text-decoration: none;
}
#home {
    padding:15px;
}
#free-board{
    padding:15px;
    color: white;   
}
#photo-board{
    padding:15px;
    color: white;   
}
#video-board{
    padding:15px;
    color: white;   
}
#music{
    padding:15px;
    color: white;   
}
.header {
    z-index: 2;
}
.list {
    z-index: 1;
}

</style>