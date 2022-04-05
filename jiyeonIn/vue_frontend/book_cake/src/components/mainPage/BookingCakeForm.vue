<template>
    <div class="calenderPage">
        
        <div>
            <h4>픽업일자 & 시간</h4>
            <calender-test></calender-test>
            <p style="font-size: 13px; padding: 5px;">*예약 확정 후 최소 3일 이상 소요되니, 이에 맞추어 픽업일 입력 부탁 드립니다. <br> *일요일, 월요일은 휴무입니다.</p>
            <hr>
        </div>

        <!--
        <div>
            <v-container class="px-0" fluid>
                    <v-radio-group row>
                    <v-radio label="케이크 선택" value="select" @click="sss()"></v-radio>
                    <v-radio label="직접 디자인 올리기" value="own" onclick="ownCake(this.value,'own')"></v-radio>
                    </v-radio-group>
            </v-container>
        </div>

        
        <div class="selectShop">
            <p>되라 이것아</p>
        </div>
        <div id="own" style="display:none;">
            <p>얍 이것아</p>
        </div>
        -->

        <v-container>
            <v-row style="height: 55px">
                <v-col class="col-12 col-sm-4">
                    <v-checkbox  label="케이크 선택" v-model="selectCake"></v-checkbox>
                </v-col>
                <v-col class="col-12 col-sm-5">
                    <v-checkbox label="직접 디자인 올리기" v-model="selectOwnCake"></v-checkbox>
                </v-col>
            </v-row>
            <v-row>
                <v-col class="col-12 col-sm-6">
                    <p style="font-size: 13px">*두개 선택지 중 1개 필수 선택 입니다!</p>
                </v-col>
            </v-row>
            
        </v-container>
        
        <div v-if="selectCake" class="selectCakes">
            <br>
            <v-select class="selectCake" v-model="findDgn" :items="selectCakeDesign" label="디자인 선택" style="width: 200px;" onchange="findDesign"></v-select>
            <v-virtual-scroll
                :bench="benched"
                :items="items"
                height="450" width="750" item-height="250" 
                class="virtualScroll">

                <template v-slot:default="{ item }">
                    <v-list-item :key="item">
                        <v-list-item-action>
                            <v-radio ></v-radio> 
                        </v-list-item-action>

                        <v-list-item-content>
                            <img :src="item.image" width="200" height="200">
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


        <div v-if="selectOwnCake">
            <p style="font-size: 15px">*아래 파일선택에 원하는 디자인을 첨부해 주세요!</p>
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
                        style="font-size: 14px">
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
            items: [
                {image:'@/assets/uploadImg/birthday/1.birhday.png', design : 'family', size: '1호', price: 22000},
                {image:'@/assets/uploadImg/birthday/1.birhday.png',design : 'lover', size: '도시락', price: 12000},
                {image:'@/assets/uploadImg/birthday/1.birhday.png',design : 'birthday', size: '1호', price: 15000},
                {image:'@/assets/uploadImg/birthday/1.birhday.png',design : 'birthday', size: '1호', price: 15000},
                {image:'@/assets/uploadImg/family/1.famaily cake.png',design : 'birthday', size: '1호', price: 15000},
                {image:'assets/uploadImg/family/1.famaily cake.png',design : 'birthday', size: '1호', price: 15000},
                {image:'@/assets/uploadImg/birthday/1.birhday.png',design : 'birthday', size: '1호', price: 15000},
                {image:'assets/uploadImg/family/1.famaily cake.png',design : 'birthday', size: '1호', price: 15000},
            ],
            selectCakeDesign : ['birthday', 'lover','family','friend'],
            findDgn:''
            
        }
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
        sss () {
            this.selectShop = !this.selectShop
            
        },
        findDesign () {
            for(let i=0; i< this.items.length ; i++) {
                if(this.items[i].design != this.findDgn){
                    continue
                }
            }
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