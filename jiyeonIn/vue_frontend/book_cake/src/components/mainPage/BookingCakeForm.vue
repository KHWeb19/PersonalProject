<template>
    <form @submit.prevent="submitBooking">
        <div class="calenderPage">
            <h4>픽업일자 & 시간</h4>
            <calender-test @submit="calendarInform" :bookingListsDate="bookingListsDate"></calender-test>
            <p style="font-size: 13px; padding: 5px;">
                *날짜, 시간 선택 후 확정 버튼 눌러주세요! <br>
                *예약 확정 후 최소 3일 이상 소요되니, 이에 맞추어 픽업일 입력 부탁 드립니다. 
                <br> *일요일, 월요일은 휴무입니다.</p>
            
        </div>
        
        <div>
            <hr><br>
            <v-container>
                <v-row style="height: 55px;" justify="center">
                    <v-col class="col-12 col-sm-1"></v-col>
                    <v-col class="col-12 col-sm-4">
                            <label>
                                <input
                                type="radio"
                                value="now"
                                name="sendType2"
                                v-model="toggleSendType"
                                />
                                케이크 선택
                            </label>
                            
                    </v-col>

                    <v-col class="col-12 col-sm-5">
                            <label>
                                <input
                                type="radio"
                                value="reserve"
                                name="sendType"
                                id="sendType"
                                v-model="toggleSendType"
                                />
                                직접 디자인 올리기
                            </label>
                    </v-col>
                </v-row>
            </v-container>
        </div>
        
        
        <div class="input-group" v-show="sendType2">
            <div class="input-group-text">
            
            <br>
            <v-select class="selectCake" v-model="findDgn" :items="selectCakeDesign" label="디자인 선택" style="width: 200px; margin:1% 1% 1% 15%;" @change="findDesign"></v-select>
            
            <v-virtual-scroll
                :items="cakeLists"
                height="900" width="850" item-height="300" 
                style="left: 10%;top: 10%;"
                class="virtualScroll"
                v-if="this.chooseDesBol != 'mine'">

                <template v-slot="{ item, index }">
                    <v-list-item :key="index">
                        <v-list-item-action>
                            <input type="radio" @change="confirmCake(item)" v-model="checkIndex" :value="index" name="checkOwnCake"/> 
                        </v-list-item-action>

                        <v-list-item-content style="width:310px; height:310px;">
                            <v-img v-bind:src="require(`@/assets/uploadImg/${item.linkInfo}`)" contain />
                        </v-list-item-content>

                        <v-list-item-action>
                        </v-list-item-action>
                        
                        <v-list-item-content>
                            <v-list-item-title>
                                design : {{item.design}} <br> 
                                size : {{item.size}} <br> 
                                price: {{item.price}}
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-divider></v-divider>
                </template>
            </v-virtual-scroll>

            <v-virtual-scroll
                :items="chooseDesignArr"
                height="800" width="750" item-height="300" 
                class="virtualScroll"
                style="left: 10%;top: 10%;"
                v-if="this.chooseDesBol == 'mine'">

                <template v-slot="{ item, index }">
                    <v-list-item :key="index">
                        <v-list-item-action>
                            <input type="radio" @change="confirmCake2(item)" v-model="checkIndex2" :value="index" name="checkSelectCake"/> 
                        </v-list-item-action>

                        <v-list-item-content style="width:310px; height:310px;">
                            <v-img v-bind:src="require(`@/assets/uploadImg/${item.linkInfo}`)" contain />
                        </v-list-item-content>

                        <v-list-item-action>
                        </v-list-item-action>

                        <v-list-item-content>
                            <v-list-item-title>
                                design : {{item.design}} <br> 
                                size : {{item.size}} <br> 
                                price: {{item.price}}
                            </v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-divider></v-divider>
                </template>
            </v-virtual-scroll>
            
            </div>
        </div>

        <div class="input-group" v-show="sendType" style="margin:1% 1% 1% 15%;">
            <div class="input-group-text">
               <p style="font-size: 15px">*아래 파일선택에 원하는 디자인을 첨부해 주세요!</p>
            </div>
        </div>

        <br><hr><br>

        <div style="margin:1% 1% 1% 15%;">
            <h4>요청사항 입력</h4><br>
            <textarea 
                placeholder="케이크 위 레터링 글자는 최대 10자 이내 
케이크 보드 위 레터링 글자는 최대 15자 이내입니다. 
비용은 추후 레터링 및 추가 요구사항 확인 후 확정됩니다.
*케이크 선택하셔도 원하시는 이미지를 직접 올려주시면 예약 확정이 빨라집니다. ^^" 
                    style="font-size: 14px;" wrap="soft" v-model="contents">
            </textarea>
            <input type="file" id="files1" ref="files1" 
                multiple v-on:change="handleFileUpload()"/>
        </div>

        <br><hr><br><br>
        <div style="text-align: center;">
            <v-btn color="black" text type="submit" style="font-size:19px;" width="260" >
                <v-icon color="black" text>mdi-check</v-icon>예약하기
            </v-btn>
        </div>  
        <br>
    </form>
</template>

<script>
import CalenderTest from '@/components/eventBusBooking/CalenderTest.vue'

export default {
    name : 'BookingCakeForm',
    props: {
        cakeLists: {
            type: Array,
            required: true
        },
        bookingListsDate: {
            type: Array,
            required: true
        },
        
    },
    data () {
        return {
            date:'',
            time:'',
            selectCake: false,
            soso1: false,
            selectOwnCake: false,
            selectCakeDesign : ['birthday', 'family','friend' , 'lover'],
            findDgn:'',
            sendType: false,
            sendType2: false,
            toggleSendType: ["now", "reserve"],
            chooseDesignArr: [],
            chooseDesBol: ['notMine', 'mine'],
            checkIndex:'',
            checkIndex2:'',
            selectEachCake:[],
            outDesign:'',
            outSize:'',
            outPrice:'',
            outImg:'',
            contents:'',
            isShow:false,
            cakeArrNo:'', //이거 가지고 갈거임
            id: (window.localStorage.getItem('id')),
        }
    },
    components: { 
        CalenderTest 
    },
    watch: {
        toggleSendType: function (data) {
            if (data == "now") this.sendType2 = true
            else this.sendType2 = false
            if (data == "reserve") this.sendType = true
            else this.sendType = false
            this.isShow = false
        },
    },
    
    methods: {
        calendarInform (payload) {
            const { date, time } = payload
            this.date = date
            this.time = time
            
        },
        findDesign () {
            this.chooseDesignArr = new Array();

            for(let i=0; i< this.cakeLists.length ; i++) {
                if(this.cakeLists[i].design == this.findDgn) {
                    this.chooseDesignArr.push(this.cakeLists[i])
                    
                }else {
                    continue
                }
            }
            this.chooseDesBol = 'mine'
            this.isShow = false
        },
        confirmCake(item){
            console.log(item.cakeNo)

            this.outDesign = item.design
            this.outSize = item.size
            this.outPrice = item.price
            this.cakeArrNo = item.cakeNo

            this.isShow = true

        },
         confirmCake2(item){
             console.log(item.cakeNo)
             this.isShow = true

            this.outDesign = item.design
            this.outSize = item.size
            this.outPrice = item.price
            this.cakeArrNo = item.cakeNo
        
         },
        
        handleFileUpload() {
            this.files1 = this.$refs.files1.files
        },
         
        submitBooking () {
            if(this.cakeArrNo > 0) {
                const {id, date, time, contents,cakeArrNo, files1} = this
                this.$emit('submit', {id, date, time, contents, cakeArrNo,files1})
            }else{
                this.cakeArrNo = 0
                const {id, date, time, contents,cakeArrNo, files1} = this
                this.$emit('submit', {id, date, time, contents, cakeArrNo,files1})
            }
        },
    }
}
    
</script>

<style scoped>

.calenderPage {
    padding: 5%;
    margin:1% 1% 1% 10%;
}

.virtualScroll {
    background-color: rgb(248, 220, 220);
    border: 1px solid;
    padding: 5%;
}

textarea {
    width: 80%;
    height: 10em;
    border: 1px solid ;
    resize: none;
  }
</style>