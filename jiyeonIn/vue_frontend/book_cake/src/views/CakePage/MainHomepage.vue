<template>
    <div class="Main">
        <header>
            <div>
            <!--<div  v-if="user.id == null" style="text-align: right;">-->
                 <router-link :to="{name: 'LoginPage'}" >
                        <span class="mainlog">&nbsp;&nbsp;&nbsp;로그인&nbsp;&nbsp;&nbsp;/ </span>
                    </router-link>
                    <router-link :to="{name: 'SignUpPage'}" >
                        <span class="mainlog">&nbsp;&nbsp;&nbsp;회원가입&nbsp;&nbsp;&nbsp;</span>
                    </router-link>
            </div>
            <div>
            <!--<div  v-if="!user.id == null" style="text-align: right;">-->
                 
                    <button type="submit" style="font-size: small; color: black;">&nbsp;&nbsp;&nbsp;로그아웃&nbsp;&nbsp;&nbsp;/ 
                    </button>
                    
                    <router-link :to="{name: 'myPage'}" >
                        <span style="font-size: small; color: black;">&nbsp;&nbsp;&nbsp;My페이지&nbsp;&nbsp;&nbsp;</span>
                    </router-link>
            </div>
            
            
            <router-link style="text-decoration: none;" :to="{name: 'MainHomepage'}" >            
                <v-img class="MainLogo"
                max-height="200" max-width="250" 
                src="@/assets/img/check.png"/>
            </router-link>
            
        </header>
        <hr>
        <v-container >
            <v-row no-gutters class="menu">
                <v-col class="col-12 col-sm-3">
                    <router-link :to="{name: 'BookingPage'}">
                        <p>예약하기</p>
                    </router-link>
                </v-col>
                <v-col class="col-12 col-sm-3">
                    <router-link :to="{name: 'BookingListPage'}">
                        <p>주문서 보기</p>
                    </router-link>
                </v-col>
                <v-col class="col-12 col-sm-3">
                    <router-link :to="{name: 'PreviewCakeImg'}">
                        <p>케이크 보기</p>
                    </router-link>
                </v-col>
                <v-col class="col-12 col-sm-2">
                   <router-link :to="{name: 'ReviewPage'}">
                        <p>후기</p>
                    </router-link>
                </v-col>
                <v-col class="col-12 col-sm-1">
                    <router-link :to="{name: 'MyPage'}">
                        <p>My페이지</p>
                    </router-link>
                </v-col>
            </v-row>
        </v-container>
        
        <v-container>
            <v-row no-gutters>
                <v-col class="col-1 col-sm-1">
                </v-col>
                <v-col class="col-6 col-sm-5">
                    <v-img src="@/assets/img/cake2.jpg" max-height="450" max-width="450"/>
                </v-col>
                <v-col class="col-6 col-sm-5">
                    <div class="notice">
                        <h4> &nbsp;&nbsp;공지사항</h4><br>
                        <ul>
                            <li>
                                1. 예약 전 필독
                            </li>
                            <li>
                                2. 예약 확정 전 필독
                            </li>
                            <li>
                                3. 후기 등록 시 추가 혜택
                            </li>
                            <br>
                            <li>
                                ** 찾아오는 길
                                <span><br>&nbsp;&nbsp;&nbsp;&nbsp;인천 1호선 테크노파크역 2번 출구 </span>
                                <span><br>&nbsp;&nbsp;&nbsp;&nbsp;트리플스트리트A동 좌측 1층입니다.</span>
                                <span><br>&nbsp;&nbsp;&nbsp;&nbsp;(인천 연수구 송도과학로 16번길 33)</span>
                            </li><br>
                            <li>
                                ** 연락처 (픽업 전 연락주세요!)<br>
                                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;T : 032-123-4567</span>
                            </li>
                            <br>
                        </ul>
                    </div>
                </v-col>
            </v-row>
        </v-container>
    </div>
</template>

<script>
    export default {
        name: 'MainHomepage',
        components: {

        }
    }
</script>


<style scoped>

.Main {
    background: rgb(255, 186, 186);
    background-size : cover;
}

.MainLogo {
    display: block; margin: 0px auto;
}

.notice {
    background: rgb(253, 207, 207);
    border: 1px solid #ff6e6e;
    padding: 10px;
    width: 300;
}
.mainlog{
    font-size: small; 
    color: black;
    padding: 15px 0px 15px 0px;
}

ul{
    list-style: none; 
}

a {
    text-decoration: none;
    font: 300;
}

p {
    color: rgb(0, 0, 0);
    font-weight: 700;
}
hr{ 
    background: #e69191;
    height: 3px;
}
</style>