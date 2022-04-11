<template>
    <form @submit.prevent="submitBooking">
        <div class="calenderPage">
            <h4>픽업일자 & 시간</h4>
            <calender-test @submit="calendarInform"></calender-test>
            <p style="font-size: 13px; padding: 5px;">*예약 확정 후 최소 3일 이상 소요되니, 이에 맞추어 픽업일 입력 부탁 드립니다. <br> *일요일, 월요일은 휴무입니다.</p>
            
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
                height="600" width="750" item-height="250" 
                style="left: 10%;top: 10%;"
                class="virtualScroll"
                v-if="this.chooseDesBol != 'mine'">

                <template v-slot="{ item, index }">
                    <v-list-item :key="index">
                        <v-list-item-action>
                            <input type="radio" @change="confirmCake" v-model="checkIndex" :value="index" name="checkOwnCake"/> 
                        </v-list-item-action>

                        <v-list-item-content style="width:200px; height:260px;">
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
                height="600" width="750" item-height="250" 
                class="virtualScroll"
                style="left: 10%;top: 10%;"
                v-if="this.chooseDesBol == 'mine'">

                <template v-slot="{ item, index }">
                    <v-list-item :key="index">
                        <v-list-item-action>
                            <input type="radio" @change="confirmCake2" v-model="checkIndex2" :value="index" name="checkSelectCake"/> 
                        </v-list-item-action>

                        <v-list-item-content style="width:200px; height:260px;">
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

        <div style="font-size: 14px; margin:1% 1% 1% 15%;"><br><p v-show="isShow">선택한 디테일 : <strong>{{ outDesign }} & {{ outSize }} & {{ outPrice }} {{outImg}}</strong>  </p></div>
        <br><hr><br>

        <div style="margin:1% 1% 1% 7%;">
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
            type: Array
        }
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
        confirmCake(){
            console.log(this.checkIndex)
            
            for(let i=0; i< this.cakeLists.length ; i++) {
                if(this.checkIndex == i) {
                    this.outDesign = this.cakeLists[i].design
                    this.outSize = this.cakeLists[i].size 
                    this.outPrice = this.cakeLists[i].price
                    this.outImg = this.cakeLists[i].linkInfo
                    this.cakeArrNo = ((this.checkIndex) +1)
                    
                    break
                }
            }

            console.log(this.cakeArrNo)
            this.isShow = true

        },
         confirmCake2(){
             console.log(this.checkIndex2)
             this.isShow = true
        
            if((this.chooseDesignArr[0].design) == 'birthday'){
                for(let i=0 ; i< this.chooseDesignArr.length ; i++){
                    if((this.checkIndex2) == (i)){
                        let num = ((this.chooseDesignArr[i].cakeNo) - 1)
                         this.outDesign = this.cakeLists[num].design
                         this.outSize = this.cakeLists[num].size 
                         this.outPrice = this.cakeLists[num].price
                         this.cakeArrNo = (this.chooseDesignArr[i].cakeNo)
                         this.outImg = this.cakeLists[num].linkInfo

                        console.log(this.cakeArrNo)
                         break
                    }
                }          
            }else if(this.chooseDesignArr[0].design == 'family'){
                for(let i=0 ; i< this.chooseDesignArr.length ; i++){
                    if((this.checkIndex2) == (i)){
                        let num = ((this.chooseDesignArr[i].cakeNo) - 1)
                         this.outDesign = this.cakeLists[num].design
                         this.outSize = this.cakeLists[num].size 
                         this.outPrice = this.cakeLists[num].price
                         this.cakeArrNo = (this.chooseDesignArr[i].cakeNo)
                         this.outImg = this.cakeLists[num].linkInfo

                        console.log(this.cakeArrNo)
                         break
                    }
                }            
            }
            else if(this.chooseDesignArr[0].design == 'friend'){
                for(let i=0 ; i< this.chooseDesignArr.length ; i++){
                    if((this.checkIndex2) == (i)){
                        let num = ((this.chooseDesignArr[i].cakeNo) - 1)
                         this.outDesign = this.cakeLists[num].design
                         this.outSize = this.cakeLists[num].size 
                         this.outPrice = this.cakeLists[num].price
                         this.cakeArrNo = (this.chooseDesignArr[i].cakeNo)
                         this.outImg = this.cakeLists[num].linkInfo

                        console.log(this.cakeArrNo)
                         break
                    }
                }           
            }else if(this.chooseDesignArr[0].design == 'lover'){
                for(let i=0 ; i< this.chooseDesignArr.length ; i++){
                    if((this.checkIndex2) == (i)){
                        let num = ((this.chooseDesignArr[i].cakeNo) - 1)
                         this.outDesign = this.cakeLists[num].design
                         this.outSize = this.cakeLists[num].size 
                         this.outPrice = this.cakeLists[num].price
                         this.cakeArrNo = (this.chooseDesignArr[i].cakeNo)
                         this.outImg = this.cakeLists[num].linkInfo

                        console.log(this.cakeArrNo)
                         break
                    }
                }          
            }
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