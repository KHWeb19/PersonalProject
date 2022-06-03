<style>

.shadow{
            font-family:  'Cute Font', cursive;
            font-size: 50px;
            font-weight: 900;
            line-height: 20px;
        }
#shadow{
            text-shadow: 0 0 4px rgb(184,179,179),
            0 -5px 4px yellow,
            2px -10px 6px orange,
            2px -19px 20px red;
        }
#sd{
    width: 100%; 
    height: 100%;
    float:left;
    position: relative;
    margin: 0;
    font-size: 0px;
    text-align: center;
}
body { 
    padding: 0; 
    margin: 0; 
    } 
#article{
    font-family:  'Cute Font', cursive;
    background-color: rgb(185,185,185); 
    text-align: right;
    margin-right: 0px;
    position: relative;
}

#vb{
    font-family:  'Cute Font', cursive;
    margin-top:20px;
    float:left;
    position: relative;
}

#vc{
    font-family:  'Cute Font', cursive;
    text-align: center;
    margin-right: 0px;
    position: relative;
}

#contact{
    width: 100%; 
    height: 80px;
    background-color:rgb(40, 44, 53) ;

    position: relative;
}
#icon{
    text-align: center;
    position: relative;
}
select {
  -moz-appearance: none;
  -webkit-appearance: none;
  appearance: none;
  
  font-family: "Noto Sansf KR", sans-serif;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  
  color: #444;
  background-color: #fff;
  
  padding: .6em 1.4em .5em .8em;
  margin: 0;
  
  border: 1px solid #aaa;
  border-radius: .5em;
  box-shadow: 0 1px 0 1px rgba(0,0,0,.04);
}

select:hover {
  border-color: #888;

}
select:focus {
  border-color: #aaa;
  box-shadow: 0 0 1px 3px rgba(59, 153, 252, .7);
  box-shadow: 0 0 0 3px -moz-mac-focusring;
  color: #222;
  outline: none;
}
select:disabled {
  opacity: 0.5;
}

</style>
<style scoped>
</style>
<template>
    <div>  
        <body>                                         
        <div>
           <div id=vb>
            <v-container v-if="this.$store.state.userInfo == null">
                <v-btn tile color="grey darken-3 white--text" onclick="location.href='http://localhost:8080/stock/register'" width="125" :style="{fontSize:'x-large'}">
                    <v-icon left>mdi-account-plus-outline</v-icon>
                    회원 가입 
                </v-btn> 
                <v-btn tile color="grey darken-2 white--text" onclick="location.href='http://localhost:8080/stock/login'" width="100" :style="{fontSize:'x-large'}"> 
                    <v-icon left>mdi-login</v-icon>
                    로그인 
                </v-btn>
            </v-container>
            <v-container v-if="this.$store.state.userInfo != null">
                <v-menu offset-y>
                <template v-slot:activator="{ on }">
                    <v-btn tile color="grey darken-3 white--text" width="100" :style="{fontSize:'x-large'}" v-on="on">
                    <v-icon left>mdi-note-edit-outline</v-icon>
                    글쓰기
                    </v-btn>
                </template>
                <v-list>
                    <v-list-item v-for="(dropItem, index) in dropItems" :key="index" :to="dropItem.to">
                        <v-list-item-title>
                            {{ dropItem.title }}
                        </v-list-item-title>
                    </v-list-item>
                </v-list>
            </v-menu>
                
                <v-btn tile color="grey darken-2 white--text" @click="logout" width="125" :style="{fontSize:'x-large'}">
                    <v-icon left>mdi-logout </v-icon>
                    로그 아웃
                </v-btn>
                <br>
                <v-dialog v-model="dialog" persisten max-width="400">
                <template v-slot:activator="{ on }">
                 <v-btn v-on="on" tile color="black white--text" onclick="" width="225" :style="{fontSize:'x-large'}">
                    <v-icon left>mdi-crown-outline</v-icon>
                    VIP 가입 
                </v-btn>
                </template>
                <v-card>
                    <v-toolbar dark>{{ service.name }}</v-toolbar>
                  
                    <br>
                    <v-card-text class="red--text" :style="{fontSize:'x-large'}" >
                        수익 실현율 +200% 달성
                    </v-card-text>
                  
                    <img src="../../assets/img/earnmoney.jpg" height="185px">
                    <br>
                    <v-card-text class="blue--text" :style="{fontSize:'large'}">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;지금 당장 결제 하시겠습니까 ?
                    </v-card-text>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <select align="center" id="selectbox" name="selectbox" onchange="chageselect()" size="3" multiple>
                    <option value=vip>10,000원(1개월)</option>
                    <option value=vip>20,000원(3개월)</option>
                    <option value=vip>35,000원(6개월)</option>
                    </select>
                    <v-card-actions>
                        <v-spacer></v-spacer>
                        <v-btn type="button" tile color="grey darken-2 white--text" width="100" :style="{fontSize:'medium'}" onclick="location.href='http://localhost:8080/stock'"><v-icon>mdi-close-circle-outline</v-icon>
                        취소</v-btn>
                         <v-btn type="submit" tile color="blue darken-2 white--text" width="100" :style="{fontSize:'medium'}" @click="onSubmit" ><v-icon> mdi-cash-check</v-icon>
                        결제</v-btn>
                    </v-card-actions>
                </v-card>
                </v-dialog>
            </v-container>
            </div>
            <div class="slide-3d"> 
            <v-container>
                 <div id="sd">
                 <span id="shadow" class="shadow">주린이를 위한 영상 시청하기</span>
                 </div>
                 <br><br><br><br><br><br>
                <swiper class="swiper" :options="swiperOption" >                   
                    <swiper-slide><a href="https://www.youtube.com/watch?v=-7PNSj9m1XA" target="_blank">
                        <img src="../../assets/img/finish.jpg"></a></swiper-slide>
                    <swiper-slide><a href="https://www.youtube.com/watch?v=qA6cX80iE_M" target="_blank">
                        <img src="../../assets/img/plusbong.jpg"></a></swiper-slide>
                    <swiper-slide><a href="https://www.youtube.com/watch?v=zTbtZnr-UsY" target="_blank">
                        <img src="../../assets/img/choice.jpg"></a></swiper-slide>    
                    <swiper-slide><a href="https://www.youtube.com/watch?v=aoYxZJrG6a8" target="_blank">
                        <img src="../../assets/img/study.jpg"></a></swiper-slide> 
                    <swiper-slide><a href="https://www.youtube.com/watch?v=cQlU1ZCdDXQ" target="_blank">
                        <img src="../../assets/img/fail.jpg"></a></swiper-slide> 
                    <swiper-slide><a href="https://www.youtube.com/watch?v=BqXHj1SyH84" target="_blank">
                        <img src="../../assets/img/10min.png"></a></swiper-slide>                             
                    <swiper-slide><a href="https://www.youtube.com/watch?v=5QYW-R8D7Cw" target="_blank">
                        <img src="../../assets/img/play.jpg"></a></swiper-slide>
                    <swiper-slide><a href="https://www.youtube.com/watch?v=QVudrTlsg8s" target="_blank">
                        <img src="../../assets/img/bigshort.jpg"></a></swiper-slide>  
                    <swiper-slide><a href="https://www.youtube.com/watch?v=6QWaJGHS6Qw" target="_blank">
                        <img src="../../assets/img/admit.jpg"></a></swiper-slide>
                    <swiper-slide><a href="https://www.youtube.com/watch?v=1uvT3XcouhY" target="_blank">
                        <img src="../../assets/img/5min.jpg"></a></swiper-slide>                  
                    <div class="swiper-pagination" slot="pagination">
                    </div>
                </swiper>         
            </v-container>
            </div>
            <v-row v-if="this.$store.state.userInfo != null" no-gutters>

            <v-menu offset-y >
                <template v-slot:activator="{ on }">    
            <v-btn id=vb tile color="black white--text" @click="searchstart" :style="{marginTop:'72px',fontSize:'x-large'}" v-on="on">                
            <v-icon>mdi-magnify</v-icon>  
            검색
            </v-btn>
            </template>
                <v-list>
                    <v-list-item v-for="(dropItem, index) in sdropItems" :key="index" :to="dropItem.to">
                        <v-list-item-title>
                            {{ dropItem.title }}
                        </v-list-item-title>
                    </v-list-item>
                </v-list>
            </v-menu>


            <v-col cols="1" md="1">
                 <v-text-field v-model="searchkeyword" dense outlined label="go to notice board" full-width :style="{marginTop:'70px'}"/>
            </v-col>
            </v-row>
            <br><br><br>
            <div id =vc v-on:click="checkLogin" >
               <v-btn v-on:click="todayvipcheck" class="purple darken-1  white--text" width="325px"  :style="{fontSize:'x-large'}">종목 추천</v-btn>

            <v-dialog v-bind:disabled="this.$store.state.userInfo == null" v-model="profitdialog" persisten max-width="395">
            <template v-slot:activator="{ on }"> 
               <v-btn v-on="on" class="red darken-1 white--text" width="325px" onclick="" :style="{fontSize:'x-large'}">수익 인증</v-btn>                                  
            </template>   
              <v-card>
                    <v-toolbar dark>{{ profit.name }}</v-toolbar>
                    <br>
                    <img src="../../assets/img/hmm.jpg" height="83px">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </v-card>  
            </v-dialog>
            <br>
            <v-btn v-on:click="nextcheckVip" v-on="on" class="deep-purple accent-1 black--text" width="325px"  :style="{fontSize:'x-large'}">2022년 5월 10일 추천 종목</v-btn>                                              
            <v-dialog v-bind:disabled="this.$store.state.userInfo == null" v-model="profit1dialog" persisten max-width="420">
            <template v-slot:activator="{ on }"> 
            <v-btn v-on="on" class="red lighten-4  black--text" width="325px"  :style="{fontSize:'x-large'}">현대차 수익 인증</v-btn>
            </template>
              <v-card>
                    <v-toolbar dark>{{ profit1.name }}</v-toolbar>
                    <br>
                    <img src="../../assets/img/hyundai.jpg" height="83px">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </v-card>  
            </v-dialog>
            <br>
            <v-btn v-on:click="checkVip" v-on="on" class="deep-purple accent-1 black--text" width="325px"  :style="{fontSize:'x-large'}">2022년 5월 11일 추천 종목</v-btn>
            <v-dialog v-bind:disabled="this.$store.state.userInfo == null" v-model="profit2dialog" persisten max-width="240">
            <template v-slot:activator="{ on }">  
            <v-btn v-on="on" class="red lighten-4 black--text" width="325px"  :style="{fontSize:'x-large'}">신세계 수익 인증</v-btn>
            </template>
              <v-card>
                    <v-toolbar dark>{{ profit2.name }}</v-toolbar>
                    <br>
                    <img src="../../assets/img/shinsegae.jpg" height="150px">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </v-card>  
            </v-dialog>
            <br>
            <v-btn  v-on:click="checkVip" v-on="on" class="deep-purple accent-1 black--text" width="325px"  :style="{fontSize:'x-large'}">2022년 5월 12일 추천 종목</v-btn> 
            <v-dialog v-bind:disabled="this.$store.state.userInfo == null" v-model="profit3dialog" persisten max-width="280">
            <template v-slot:activator="{ on }">
            <v-btn v-on="on" class="red lighten-4 black--text" width="325px"  :style="{fontSize:'x-large'}">바이넥스 수익 인증</v-btn>
            </template>
              <v-card>
                    <v-toolbar dark>{{ profit3.name }}</v-toolbar>
                    <br>
                    <img src="../../assets/img/binex.jpg" height="110px">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </v-card>  
            </v-dialog>
            <br>
            <v-btn v-on:click="checkVip" v-on="on" class="deep-purple accent-1 black--text" width="325px"  :style="{fontSize:'x-large'}">2022년 5월 13일 추천 종목</v-btn> 
            <v-dialog v-bind:disabled="this.$store.state.userInfo == null" v-model="profit4dialog" persisten max-width="315">
            <template v-slot:activator="{ on }">
            <v-btn v-on="on" class="red lighten-4 black--text" width="325px"  :style="{fontSize:'x-large'}">네이처셀 수익 인증</v-btn>
             </template>
              <v-card>
                    <v-toolbar dark>{{ profit4.name }}</v-toolbar>
                    <br>
                    <img src="../../assets/img/naturecell.jpg" height="100px">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </v-card>  
            </v-dialog> 
            <br>
            <v-btn v-on:click="checkVip" v-on="on" class="deep-purple accent-1 black--text" width="325px"  :style="{fontSize:'x-large'}">2022년 5월 16일 추천 종목</v-btn> 
            <v-dialog v-bind:disabled="this.$store.state.userInfo == null" v-model="profit5dialog" persisten max-width="255">
            <template v-slot:activator="{ on }">
            <v-btn v-on="on" class="red lighten-4 black--text" width="325px"  :style="{fontSize:'x-large'}">TRUE인버스2X 천연가스 수익 인증</v-btn>
            </template>
              <v-card>
                    <v-toolbar dark>{{ profit5.name }}</v-toolbar>
                    <br>
                    <img src="../../assets/img/gas.jpg" height="150px">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </v-card>  
            </v-dialog> 
            <br>
            <v-btn v-on:click="checkVip" v-on="on" class="deep-purple accent-1 black--text" width="325px"  :style="{fontSize:'x-large'}">2022년 5월 17일 추천 종목</v-btn> 
            <v-dialog v-bind:disabled="this.$store.state.userInfo == null" v-model="profit6dialog" persisten max-width="240">
            <template v-slot:activator="{ on }">
            <v-btn v-on="on" class="red lighten-4 black--text" width="325px"  :style="{fontSize:'x-large'}">인지컨트롤스 수익 인증</v-btn>
            </template>
              <v-card>
                    <v-toolbar dark>{{ profit6.name }}</v-toolbar>
                    <br>
                    <img src="../../assets/img/inzi.jpg" height="150px">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </v-card>  
            </v-dialog> 
            <br>
            </div>           
        </div>
        </body>
    </div>     
</template>
<script>
import swal from 'sweetalert';
import { swiper, swiperSlide } from 'vue-awesome-swiper'
import 'swiper/dist/css/swiper.css'
import axios from 'axios'
export default {
 
    mounted () { 
        window.addEventListener('scroll', this.onScroll) 
        }, 
        beforeDestroy () { 
        window.removeEventListener('scroll', this.onScroll) 
        },
    
    created () {
        this.id = this.$store.state.userInfo.id
        this.auth = this.$store.state.userInfo.auth
        this.nickname = this.$store.state.userInfo.nickname
    },

    components: {
        swiper,
        swiperSlide
    },
    data () {
        return {
            showNavbar: true, 
            lastScrollPosition: 0 ,
            swiperOption: {
                loop: true,
                effect: 'coverflow',
                grabCursor: true,
                centeredSlides: true,
                slidesPerView: 'auto',
                coverflowEffect: {
                    rotation: 50,
                    stretch: 0,
                    depth: 100,
                    // 회전을 많이 먹이고 싶은 경우 높이도록 한다.
                    modifier: 1,
                    slideShadows: true
                },
                pagination: {
                    el: '.swiper-pagination',
                    dynamicBullets: true
                },
                autoplay: {
                    delay: 1000
                }
            },
            dropItems: [
                { title: '국내 주식 분석', to:'/stock/LocalRegister'},
                { title: '해외 주식 분석', to:'/stock/ForeignRegister'},
                { title: '질문', to:'/stock/QuestionRegister'},
                { title: '하소연', to:'/stock/ComplaintRegister'}
            ],

            sdropItems: [
                { title: '국내 검색', to:'/stock/LocalList'},
                { title: '해외 검색', to:'/stock/ForeignList'},
                { title: '질문 검색', to:'/stock/QuestionList'},
                { title: '하소연 검색', to:'/stock/ComplaintList'}
            ],

            dialog: false,
            service: {
                name: '종목 추천의 VIP 가입!'
            },
            profitdialog: false,
            profit:{
                name: 'best 수익 인증!'
            },
            profit1dialog: false,
            profit1:{
                name: '현대차 수익 인증!'
            },
            profit2dialog: false,
            profit2:{
                name: '신세계 수익 인증!'
            },
            profit3dialog: false,
            profit3:{
                name: '바이넥스 수익 인증!'
            },
             profit4dialog: false,
            profit4:{
                name: '네이처셀 수익 인증!'
            },
            profit5dialog: false,
            profit5:{
                name: 'TRUE인버스2X 천연가스 수익 인증!'
            },
            profit6dialog: false,
            profit6:{
                name: '인지컨트롤스 수익 인증!'
            },
      id: '',
      pw: '',
      nickname:'', 
        }
    },
    methods: {
        onScroll () {
            const currentScrollPosition = window.pageYOffset || document.documentElement.scrollTop 
            if (currentScrollPosition < 0) { return } // Stop executing this function if the difference between // current scroll position and last scroll position is less than some offset 
            if (Math.abs(currentScrollPosition - this.lastScrollPosition) < 60) {return } 
            this.showNavbar = currentScrollPosition < this.lastScrollPosition 
            this.lastScrollPosition = currentScrollPosition 
            },       
        logout () {
            swal({     
                text: "로그아웃 되었습니다.",
                icon:"success"
                })
                this.$cookies.remove("user")
                this.isLogin = false
                this.$store.state.userInfo = null
                this.$store.state.userInfo.auth = null
                },      
        checkLogin(){
            if(this.$store.state.userInfo == null){
                swal({
                    text: "로그인을 먼저 해주세요.",
                    icon:"warning"
                    })
            }
            },
        todayvipcheck(){ 
            if(this.$store.state.userInfo.auth == null)
            swal({
                icon:'warning',
                title:'잠깐...',
                text:'VIP 회원에 먼저 가입하세요.',
                })
                else{
                     window.open("https://cafeptthumb-phinf.pstatic.net/MjAyMjA1MDZfOTMg/MDAxNjUxODE5MDg3MTUw.0Aa-Q5tThpxLRH3N2Z4xPsDIQB0unXyL8w5Kc93_A2kg.4rzQDTkv9h189ia9uzl16KzIGVciDYoqEolEI6sfqvkg.JPEG/%EC%B6%94%EC%B2%9C%EC%A2%85%EB%AA%A92.jpg?type=w1600", "resizable=on","left=580,top=180,width=390,height=290")
                }
        },
        nextcheckVip(){
            if(this.$store.state.userInfo.auth == null)
            {
                swal({
                    icon:'warning',
                    title:'잠깐...',
                    text:'VIP 회원에 먼저 가입하세요.',
                    })
            }
            else{
                window.open("https://cafeptthumb-phinf.pstatic.net/MjAyMjA1MDZfNCAg/MDAxNjUxODE5NjIyNzA4.-RfUPpzqi9IB8q-G5G6kib9VwRqt6Jejn7EKN7arlfEg.FSgKSPkLZHOtACy_jntD6aXCJFFmI62gCDN0FWfPxF4g.JPEG/%EC%B6%94%EC%B2%9C%EC%A2%85%EB%AA%A93.jpg?type=w1600", "resizable=on","left=580,top=180,width=390,height=275")
            }
        },   
        checkVip(){
            if(this.$store.state.userInfo.auth == null)
            {
                swal({
                    icon:'warning',
                    title:'잠깐...',
                    text:'VIP 회원에 먼저 가입하세요.',
                    })
            }
            else{
                swal({
                    text: "하루 전에 공개합니다.",
                    icon:"info"
                    })
            }
        },
        onSubmit () {
            if(this.$store.state.userInfo.auth != null)
            {
                swal({
                    text: "이미 VIP 회원에 가입되어 있습니다.",
                    icon:"info"
                    })
                    this.$router.push({
                        name: 'MainPage'
                        })
            }               
            else{
                const { id, pw, nickname } = this
                const auth = (auth != 'vip' ? 'vip' : 'general')
                this.$emit('submit', { id, pw, auth, nickname })
                axios.post('http://localhost:7777/vueJpaMember/vipjoin', { id, pw, auth, nickname })
                .then(() => {
                    swal({
                        text: "VIP 회원에 가입되었습니다! 다시 로그인을 해주세요!",
                        icon:"success"
                        })
                        this.$router.push({
                            name: 'LoginPage'
                            })
                            this.$cookies.remove("user")
                            this.isLogin = false
                            this.$store.state.userInfo = null
                            this.$store.state.userInfo.auth = null
                            })
                            .catch(res => {
                                swal(res.response.data.message)
                                })
            }
        },
    },
}

</script>

<style lang="scss" scoped>

.slide-3d {
    width: 100%;
    height: 400px;
    padding-top: 50px;
    padding-bottom: 50px;
}

.swiper {
    height: 100%;
    width: 100%;
}

.swiper-slide {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 360px;
    height: 200px;
    text-align: center;
    font-weight: bold;
    font-size: 1.7rem;
    background-position: center;
    background-size: cover;
}
</style>