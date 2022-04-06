<template>
    <div class="calenderPage">
        
        <div>
            <h4>픽업일자 & 시간</h4>
            <calender-test></calender-test>
            <p style="font-size: 13px; padding: 5px;">*예약 확정 후 최소 3일 이상 소요되니, 이에 맞추어 픽업일 입력 부탁 드립니다. <br> *일요일, 월요일은 휴무입니다.</p>
            <hr>
        </div>





        <div>
            <v-container>
                <v-row style="height: 55px;">
                    <v-col class="col-12 col-sm-4">
                        <div class="radio">
                            <label>
                                <input
                                type="radio"
                                value="now"
                                name="sendType2"
                                v-model="toggleSendType"
                                />
                                케이크 선택
                            </label>
                            
                        </div>
                    </v-col>
                    <v-col v-col class="col-12 col-sm-5">
                        <div class="radio">
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
                            
                        </div>
                    </v-col>
                </v-row>
            </v-container>
        </div>
        
        
        
        <div class="input-group" v-show="sendType2">
            <div class="input-group-text">
            
            <br>
            <v-select class="selectCake" v-model="findDgn" :items="selectCakeDesign" label="디자인 선택" style="width: 200px;" onchange="findDesign"></v-select>
            
            <v-virtual-scroll
                :items="cakeArr"
                height="600" width="750" item-height="250" 
                class="virtualScroll">

                <template v-slot:default="{ item }">
                    <v-list-item :key="item">
                        <v-list-item-action>
                            <v-radio ></v-radio> 
                        </v-list-item-action>

                        <v-list-item-content style="width:230px; height:250px;">
                            <v-img v-bind:src="item.image" cover/>
                        </v-list-item-content>
                        
                        <v-list-item-content>
                        </v-list-item-content>
                        
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
            <br><p>선택한 케이크 : {{item}}</p>

            </div>
        </div>
        <div class="input-group" v-show="sendType">
            <div class="input-group-text">
               <p style="font-size: 15px">*아래 파일선택에 원하는 디자인을 첨부해 주세요!</p>
            </div>
        </div>
       <br><hr>


        
        <br>
        <h4>요청사항 입력</h4><br>
        <v-container>
            <v-row>
                <v-col class="col-12 col-sm-12">
                    <textarea 
                        placeholder="케이크 위 레터링 글자는 최대 10자 이내 
케이크 보드 위 레터링 글자는 최대 15자 이내입니다. 
비용은 추후 레터링 및 추가 요구사항 확인 후 확정됩니다." 
                        style="font-size: 14px;" wrap="soft">
                    </textarea>
                </v-col>
                <v-col class="col-12 col-sm-3">
                    <input type="file" id="files" ref="files" 
                        multiple v-on:change="handleFileUpload()"/>
                </v-col>
            </v-row>
        </v-container><hr><br>
        

        <div style="text-align: center;">
            <v-btn color="black" text type="submit" @click="submitBooking" style="font-size:19px;" width="260">
                <v-icon color="black" text type="submit" >mdi-check</v-icon>예약하기
            </v-btn>
        </div>
        
            
    </div>

    
</template>

<script>
import CalenderTest from '@/components/eventBusBooking/CalenderTest.vue'
import EventBus from '@/eventBus.js'


export default {
    name : 'BookingCakeForm',
    data () {
        return {
            date:[],
            time:[],
            selectCake: false,
            soso1: false,
            selectOwnCake: false,
            cakeArr: [
                {image: require('@/assets/uploadImg/family/1.famaily cake.png'), design : 'family', size: '1호', price: 22000},
                {image: require('@/assets/uploadImg/lover/1.lover.png'), design : 'lover', size: '도시락', price: 12000},
                {image: require('@/assets/uploadImg/birthday/1.birhday.png'), design : 'birthday', size: '1호', price: 15000},
                {image: require('@/assets/uploadImg/birthday/2.birhday(2).png'), design : 'birthday', size: '1호', price: 15000},
                {image: require('@/assets/uploadImg/birthday/3.birhday(3).png'), design : 'birthday', size: '1호', price: 15000},
                {image: require('@/assets/uploadImg/birthday/4.birhday(4).png'), design : 'birthday', size: '1호', price: 15000},
                {image: require('@/assets/uploadImg/birthday/5.birhday(5).png'), design : 'birthday', size: '1호', price: 15000},
                {image: require('@/assets/uploadImg/lover/2.lover(2).png'), design : 'lover', size: '도시락', price: 12000},
            ],
            selectCakeDesign : ['birthday', 'lover','family','friend'],
            findDgn:'',
            sendType: false,
            sendType2: false,
            toggleSendType: ["now", "reserve"],
        
        }
    },
    watch: {
        toggleSendType: function (data) {
            if (data == "now") this.sendType2 = true
            else this.sendType2 = false
            if (data == "reserve") this.sendType = true
            else this.sendType = false
        },
    },
    components: { 
        CalenderTest 
    },
    created () {
        EventBus.$on('calendarInform', (payload) => {
            this.date =  payload[0]
            this.time = payload[1]

        })
    },
    methods: {
        findDesign () {
            for(let i=0; i< this.items.length ; i++) {
                if(this.items[i].design != this.findDgn){
                    continue
                }
            }
        },
        submitBooking () {

        }
    }
    
}
    
</script>

<style scoped>

.calenderPage {
    padding: 5%;
    margin: 20px;
}

.virtualScroll {
    background-color: rgb(248, 220, 220);
    border: 1px solid;
    padding: 5%;
}

textarea {
    width: 80%;
    height: 6.25em;
    border: 1px solid ;
    resize: none;
  }
</style>