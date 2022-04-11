<template>
    <div>
        <v-container>
            <v-row >
                <v-col class="col-12 col-sm-3">
                    <h4>!! {{BookingBoard.process}} !!</h4>
                </v-col>
                <v-col class="col-12 col-sm-6" style="text-align: center;">
                    <h3>{{BookingBoard.id}} 님의 주문서 입니다.</h3>
                </v-col >
            </v-row>
            <v-row>
                <v-col class="col-12 col-sm-3">
                </v-col>
                <v-col class="col-12 col-sm-9" style="text-align: right;">
                    <p>등록일자 : {{BookingBoard.regDate}}</p>
                </v-col>
            </v-row>
        </v-container>
        <hr><hr><hr><br>


        <v-container v-if="BookingBoard.design != null && BookingBoard.linkInfo == null" style="padding: 5% 5% 5% 15%; border:1">
             <v-row >
                <p>* 픽업 일자 : {{BookingBoard.date}}</p>
            </v-row>
            <v-row >
                <p>* 픽업 시간 : {{BookingBoard.time}}</p>
            </v-row>
            <v-row >
                <p>* 디자인 : {{BookingBoard.design}}</p>
            </v-row>
            <v-row >
                <p>* 사이즈 : {{BookingBoard.size}}</p>
            </v-row>
            <v-row >
                <p>* 가격 : {{BookingBoard.price}}</p>
            </v-row>
            <v-row >
                <p>* 요청사항 : {{BookingBoard.contents}}</p>
            </v-row>
            <v-row >
                <p>* 선택한 케이크 : </p>
            </v-row>
            <v-row >
                <v-col class="col-12 col-sm-5">
                    <v-img v-bind:src="require(`@/assets/uploadImg/${cakeLists[ ((BookingBoard.cakeArrNo) -1)].linkInfo}`)" contain />
                </v-col>
            </v-row>
            <v-row >
                <p></p><br>
            </v-row>
        </v-container>

        <v-container v-if="BookingBoard.design != null && BookingBoard.linkInfo != null" style="padding: 5% 5% 5% 15%; border:1">
             <v-row >
                <p>* 픽업 일자 : {{BookingBoard.date}}</p>
            </v-row>
            <v-row >
                <p>* 픽업 시간 : {{BookingBoard.time}}</p>
            </v-row>
            <v-row >
                <p>* 디자인 : {{BookingBoard.design}}</p>
            </v-row>
            <v-row >
                <p>* 사이즈 : {{BookingBoard.size}}</p>
            </v-row>
            <v-row >
                <p>* 가격 : {{BookingBoard.price}}</p>
            </v-row>
            <v-row >
                <p>* 요청사항 : {{BookingBoard.contents}}</p>
            </v-row>
            <v-row >
                <p>* 선택한 케이크 : </p>
            </v-row>
            <v-row >
                <v-col class="col-12 col-sm-5">
                    <v-img v-bind:src="require(`@/assets/uploadImg/${cakeLists[((BookingBoard.cakeArrNo)-1)].linkInfo}`)" contain />
                </v-col>
            </v-row>
            <v-row >
                <p>* 첨부한 디자인 : </p>
            </v-row>
            <v-row >
                <v-col class="col-12 col-sm-5">
                    <v-img v-bind:src="require(`@/assets/bookingImg/${BookingBoard.linkInfo}`)" contain />
                </v-col>
            </v-row>
            <v-row >
                <p></p><br>
            </v-row>
        </v-container>

        <v-container v-if="BookingBoard.design == null && BookingBoard.linkInfo != null" style="padding: 5% 5% 5% 15%; border:1">
             <v-row >
                <p>* 픽업 일자 : {{BookingBoard.date}}</p>
            </v-row>
            <v-row >
                <p>* 픽업 시간 : {{BookingBoard.time}}</p>
            </v-row>
            <v-row >
                <p>* 요청사항 : {{BookingBoard.contents}}</p>
            </v-row>
            <v-row >
                <v-col class="col-12 col-sm-5">
                     <v-img v-bind:src="require(`@/assets/bookingImg/${BookingBoard.linkInfo}`)" contain />
                </v-col>
            </v-row>
            <v-row >
                <p></p><br>
            </v-row>
        </v-container>

        <v-container v-if="BookingBoard.design == null && BookingBoard.linkInfo == null" style="padding: 5% 5% 5% 15%; border:1">
             <v-row >
                <p>* 픽업 일자 : {{BookingBoard.date}}</p>
            </v-row>
            <v-row >
                <p>* 픽업 시간 : {{BookingBoard.time}}</p>
            </v-row>
            <v-row >
                <p>* 요청사항 : {{BookingBoard.contents}}</p>
            </v-row>
            <v-row >
                <v-col class="col-12 col-sm-5">
                    <p>디자인 관련 이미지가 없습니다!</p>
                </v-col>
            </v-row>
            <v-row >
                <p></p><br>
            </v-row>
        </v-container>

        <br>
        <hr><hr><hr>
        <br>
    </div>
</template>

<script>
    export default {
        name:'BookingListPageForm',
        props: {
            BookingBoard: {
                type: Object,
                required: true
            },
            cakeLists: {
                type: Array,
                required: true
            }
        },
        data () {
            return {
            }
        },
        
    }
</script>

<style scoped>
</style>