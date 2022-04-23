<template>
    <div class="Main">
        <main-page-form></main-page-form>

        <div class="wrap">
            <v-container>
                <v-row>
                    <v-col class="col-12 col-sm-5" style="text-align: center;">
                        <h3>예약 전 필독</h3>
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
            
            <v-container style="padding: 5% 5% 5% 15%; border:1px solid;  height: 200px; width: 800px">
                <v-row >
                    <p>* 픽업일자는 예약일 포함 최소 4일 전에 요청 주셔야합니다!</p>
                </v-row>
                <v-row >
                    <p>* 예약 시 픽업일자 & 픽업시간 입력 후 옆에 확정 버튼 꼭 눌러주세요!</p>
                </v-row>
                <v-row >
                    <p>* 빠른 예약 확정을 위해서, 이미지 첨부는 잊지 말아주세요!</p>
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
        name: 'BeforeBooking',
        components: {
            MainPageForm, 
            FooterForm
        }
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
