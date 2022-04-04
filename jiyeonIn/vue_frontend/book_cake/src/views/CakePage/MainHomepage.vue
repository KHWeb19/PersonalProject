<template>
    <div class="Main">
        
        <main-page-form ></main-page-form>
        
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
        <footer-form></footer-form>
    </div>
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '@/components/layout/FooterForm.vue'

    export default {
        name: 'MainHomepage',
        components: {
                MainPageForm,
                FooterForm
        }
    }
    
</script>


<style scoped>

.Main {
    background: rgb(255, 186, 186);
    background-size : cover;
}

.notice {
    background: rgb(253, 207, 207);
    border: 1px solid #ff6e6e;
    padding: 10px;
    width: 300;
}

ul{
    list-style: none; 
}

a {
    text-decoration: none;
    font: 300;
}

</style>