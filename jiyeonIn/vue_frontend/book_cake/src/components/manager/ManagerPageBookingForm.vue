<template>
    <div class="myPageForm">
        <h4>MY 페이지</h4>
        <br><br>
        <div class="left_menu">
            <ul>
                <li>
                    <router-link :to="{ name: 'ManagerPageMember'}">
                        <strong> 회원 정보 확인 </strong>
                    </router-link>
                </li>
                <br>
                <li>
                    <router-link :to="{ name: 'ManagerPageBooking'}">
                        <strong> 예약 정보 확인  </strong>
                    </router-link>
                </li>
                <br>
                <li>
                    <router-link :to="{ name: 'ManagerPageCake'}">
                        <strong> 케이크 정보 확인 </strong>
                    </router-link>
                </li>
            </ul>
        </div>

        <div class="right_content">
            <h4>예약 정보 확인</h4><br>
            <v-select class="selectCake" v-model="findList" :items="selectProcess" label="디자인 선택" style="width: 200px;" @change="findDesign"></v-select>
            
            <v-data-table :headers="headerTitle1" :items="bookingLists"  class="elevation-0" v-if="this.chooseDesBol != 'mine'">
                <template v-slot:[`item.title`]="{ item }">
                   <router-link :to="{ name: 'BookingReadPage',
                                    params: { bookingNo: item.bookingNo.toString() } }"
                                    style="color:black; float:left">
                    {{ item.id }} 님의 주문서입니다. [{{item.commentList.length}}]
                   </router-link>
                </template>
            </v-data-table>

            <v-data-table :headers="headerTitle2" :items="chooseProcessArr"  class="elevation-1" v-if="this.chooseDesBol == 'mine'">
                <template v-slot:[`item.title`]="{ item }">
                   <router-link :to="{ name: 'BookingReadPage',
                                    params: { bookingNo: item.bookingNo.toString() } }"
                                    style="color:black; float:left">
                    {{ item.id }} 님의 주문서입니다. [{{item.commentList.length}}]
                   </router-link>
                </template>
            </v-data-table>
        </div>
    </div>
</template>

<script>
    export default {
        name:'ManagerPageBookingForm',
        props: {
            bookingLists: {
                type: Array,
                required: true
            },
        },
        data() {
            return {
                headerTitle1: [
                { text:'no', value: 'bookingNo', width:'10px'},
                { text:'process', value: 'process', width:'10px'},
                { text: 'content', value: 'title', width: "100px" },
                { text: 'date', value: 'regDate', width: "70px" },
                ],
                headerTitle2: [
                { text:'no', value: 'bookingNo', width:'10px'},
                { text:'process', value: 'process', width:'10px'},
                { text: 'content', value: 'title', width: "100px" },
                { text: 'date', value: 'regDate', width: "70px" },
                ],
                selectProcess: ['전체보기','예약중','예약확정','작업중','픽업완료','예약취소'],
                findList:'',
                chooseProcessArr:[],
                chooseDesBol: ['notMine', 'mine'],
            }
        },
        methods: {
            findDesign () {
                this.chooseProcessArr = new Array();

                if(this.findList == '전체보기'){
                    return this.chooseDesBol = 'notMine'
                }
                else {
                    for(let i=0; i< this.bookingLists.length ; i++) {
                        if(this.bookingLists[i].process == this.findList) {
                            this.chooseProcessArr.push(this.bookingLists[i])
                            
                        }else {
                            continue
                        }
                        this.chooseDesBol = 'mine'
                    }
                }
            },
        }
    }
</script>

<style scoped>
.myPageForm{
    display: grid;
    grid-template-columns: 90px 1000px;
}
.left_menu {
    width: 200px;
    border-right-width:3px; border-right-color:rgb(226, 154, 154);; border-right-style:dotted;
    padding: 3%;
}

.right_content {
    margin: 5% 0 0 20%;
}


ul a {
    color: inherit;
}

ul{
    list-style: none;
    margin: 20% 0 0 0;
}

a {
    text-decoration: none;
}
</style>