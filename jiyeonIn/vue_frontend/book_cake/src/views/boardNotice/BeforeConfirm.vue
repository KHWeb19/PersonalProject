<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="wrap">
            <v-container>
                <v-row>
                    <v-col class="col-12 col-sm-5" style="text-align: center;">
                        <h3>예약 확정 전 필독</h3>
                    </v-col >
                </v-row>
                <v-row>
                    <v-col class="col-12 col-sm-3">
                    </v-col>
                    <v-col class="col-12 col-sm-9" style="text-align: right;">
                        <p>등록일자 : 2022.4.11 오전 10:00:00</p>
                    </v-col>
                </v-row>
            </v-container>
            
            <v-container style="padding: 5% 5% 5% 5%; border:1px solid;  height: 230px; width: 800px">
                <v-row >
                    <p>* 예약하시면 하루 이내에 댓글로 가격 확정 드립니다.</p>
                </v-row>
                <v-row >
                    <p>* 예약금 (기본 10,000원, 케이크에 따라 달라짐_댓글에 표기) 송금 주시면 바로 예약 확정됩니다.</p>
                </v-row>
                <v-row >
                    <p>* 확정 후 취소하시면 환불 불가! 신중하게 결정하신 후 예약금 송금 주세요!</p>
                </v-row>
                <v-row >
                    <p>* 예약금을 주시지 않은 상태로 픽업일 3일 이내가 된다면 자동 취소되니 유의해주세요!</p>
                    <br>
                </v-row>
            </v-container>
            <br>
            <div class="illbeback" style="text-align: center;">
            <v-btn color="black" text >
                <router-link :to="{ name: 'BookingListPage'}" >
                        돌아가기
                </router-link>
            </v-btn>
        </div>
        </div>
        
        <footer-form ></footer-form>
    </div>
</template>

<script>
import MainPageForm from '@/components/layout/MainPageForm.vue'
import FooterForm from '@/components/layout/FooterForm.vue'

    export default {
        name: 'BeforeConfirm',
        components: {
            MainPageForm, 
            FooterForm
        },
    }
</script>

<style scoped>
.Main {
    background: rgb(255, 186, 186);
}

.wrap {
    margin:2% 10% 3% 10%;
    padding: 15px;
    border: 3px solid rgb(243, 180, 180);
}

.illbeback  a{
    text-decoration: none; 
    color: inherit;
}

</style>