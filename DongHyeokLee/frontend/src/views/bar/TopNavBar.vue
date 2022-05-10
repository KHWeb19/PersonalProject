<template>
    <div class="header">
        <v-toolbar id="header-color" dense dark>
        <!-- 홈 -->
        <div>
            <router-link :to="{ name: 'HomeView' }">
                <v-icon  class="home">
                    mdi-home
                </v-icon>
            </router-link>  
        </div>
        <!-- 자유게시판 -->
        <div>
            <router-link class="free-board" :to="{ name: 'FreeBoardListPage' }">
                BOARD
            </router-link>
        </div>
        <!-- 사진 게시판 -->
         <div>
            <router-link class="photo-board" :to="{ name: 'PhotoBoardListPage' }">
                PHOTO
            </router-link>
        </div>
        <!-- 영상 게시판 -->
          <div>
            <router-link class="video-board" :to="{ name: 'VideoBoardListPage' }">
                VIDEO
            </router-link>
        </div>
         <!-- 뮤직 플레이어 -->
          <div>
            <router-link class="music" :to="{ name: 'PlayListPage' }">
                MUSIC
            </router-link>
        </div>
        <!-- 멤버 관리 -->
            <v-spacer></v-spacer>
        <div v-if="!this.$store.state.isLogin" > 
             <!-- 회원가입, 로그인-->
            <v-toolbar-title>         
                <member-sign-up class="sign-up"/>
                <member-login class="login"/>
            </v-toolbar-title>
        </div>
            
        <div v-if="this.$store.state.isLogin">
            <!-- 로그아웃, 마이페이지 -->
            <v-toolbar-title>         
                <member-my-page class="my-page"/>
                <member-logout class="logout"/>
            </v-toolbar-title>
        </div>
        
        <div>
            <v-app-bar-nav-icon  @click="nav_drawer = !nav_drawer" color="amber lighten-2">
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
                //{ icon: 'mdi-vlive' , text: 'AKMU', router: 'https://www.vlive.tv/channel/F36179'}
            ],
     
        }
    }
}
</script>


<style scoped>

#header-color{
    background-color: black;
}
a{
    text-decoration: none;
    
}
a:hover{
    text-decoration: none;
}
.home {
    padding:15px;
    color: #FFD54F;
}
.free-board{
    padding:15px;
    color: #FFD54F;   
}
.photo-board{
    padding:15px;
    color: #FFD54F;   
}
.video-board{
    padding:15px;
    color: #FFD54F;   
}
.music{
    padding:15px;
    color: #FFD54F;  
}
.header {
    z-index: 2;
}
.list {
    z-index: 1;
}

</style>