<template>
    <div>
        <v-container v-if="(dbrAction != 'manager') || (checkuserInfo == null)">
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

        <form @submit.prevent="onSubmit">
        <v-container v-show="(dbrAction == 'manager') && (checkuserInfo != null)">
            <v-row >
                <v-col class="col-12 col-sm-3">
                    <v-select class="checkProcess" v-model="process" :items="selectProcess" label="진행사항 체크"></v-select>
                </v-col>
                <v-col class="col-12 col-sm-6" style="text-align: center;">
                    <h3>{{BookingBoard.id}} 님의 주문서 입니다.</h3>
                </v-col >
                <v-col class="col-12 col-sm-3" style="text-align: right;">
                    <v-btn color="black" text type="submit">수정 완료</v-btn>
                </v-col>
            </v-row>
            <v-row>
                <v-col class="col-12 col-sm-3">
                </v-col>
                <v-col class="col-12 col-sm-9" style="text-align: right;">
                    <p>등록일자 : {{BookingBoard.regDate}}</p>
                </v-col>
            </v-row>
        </v-container>
        </form>
        <hr><hr><hr><br>


        <v-container v-if="BookingBoard.design != null && BookingBoard.linkInfo == null" style="padding: 5% 5% 5% 15%; border:1">
             <v-row >
                <p>* 픽업 일자 : {{BookingBoard.date}}</p>
            </v-row>
            <v-row >
                <p>* 픽업 시간 : {{BookingBoard.time}}</p>
            </v-row>
            <v-row >
                <p>* 디자인 : {{cakeLists[((BookingBoard.cakeArrNo) -1)].design}}</p>
            </v-row>
            <v-row >
                <p>* 사이즈 : {{cakeLists[((BookingBoard.cakeArrNo) -1)].size}}</p>
            </v-row>
            <v-row >
                <p>* 가격 : {{cakeLists[((BookingBoard.cakeArrNo) -1)].price}}</p>
            </v-row>
            <v-row >
                <p>* 요청사항 : {{BookingBoard.contents}}</p>
            </v-row>
            <v-row >
                <p>* 선택한 케이크 : </p>
            </v-row>
            <v-row >
                <v-col class="col-12 col-sm-6">
                    <v-img v-bind:src="require(`@/assets/uploadImg/${this.cakeLists[(this.BookingBoard.cakeArrNo-1)].linkInfo}`)" contain />
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
                <p>* 디자인 : {{cakeLists[((BookingBoard.cakeArrNo) -1)].design}}</p>
            </v-row>
            <v-row >
                <p>* 사이즈 : {{cakeLists[((BookingBoard.cakeArrNo) -1)].size}}</p>
            </v-row>
            <v-row >
                <p>* 가격 : {{cakeLists[((BookingBoard.cakeArrNo) -1)].price}}</p>
            </v-row>
            <v-row >
                <p>* 요청사항 : {{BookingBoard.contents}}</p>
            </v-row>
            <v-row >
                <p>* 선택한 케이크 : </p>
            </v-row>
            <v-row >
                <v-col class="col-12 col-sm-6">
                    <v-img v-bind:src="require(`@/assets/uploadImg/${cakeLists[((this.BookingBoard.cakeArrNo)-1)].linkInfo}`)" contain />
                </v-col>
            </v-row>
            <v-row >
                <p>* 첨부한 디자인 : </p>
            </v-row>
            <v-row >
                <v-col class="col-12 col-sm-6">
                    <v-img v-bind:src="require(`@/assets/bookingImg/${this.BookingBoard.linkInfo}`)" contain />
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
                <p>* 첨부한 디자인 : </p>
            </v-row>
            <v-row >
                <v-col class="col-12 col-sm-6">
                     <v-img v-bind:src="require(`@/assets/bookingImg/${this.BookingBoard.linkInfo}`)" contain />
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
                *디자인 관련 이미지가 없습니다!
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
            },
            bookingNo: {
                type: String,
                required: true
            }
        },
        data () {
            return {
                dbrAction: (window.localStorage.getItem('id')),
                checkuserInfo: window.localStorage.getItem('token'),
                selectProcess: ['예약중','예약확정','작업중','픽업완료','예약취소'],
                process:'',
                id:this.BookingBoard.id,
                date: this.BookingBoard.date,
                time: this.BookingBoard.time,
                regDate: this.BookingBoard.regDate,
                contents: this.BookingBoard.contents,
                linkInfo: this.BookingBoard.linkInfo,
                cakeArrNo: this.BookingBoard.cakeArrNo,
                design: this.BookingBoard.design,
                size: this.BookingBoard.size,
                price: this.BookingBoard.price

            }
        },
        methods: {
            onSubmit () {

                const { id, date, time, process, contents, linkInfo, cakeArrNo, design, size, price, regDate } = this
                this.$emit('submit', { id, date, time, process, contents, linkInfo, cakeArrNo, design, size, price, regDate })
            }
        }
        
    }
</script>

<style scoped>
</style>