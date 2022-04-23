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
                    <router-link :to="{ name: 'ManagerPageCake'}">
                        <strong> 케이크 정보 확인  </strong>
                    </router-link>
                </li>
            </ul>
        </div>

        <div class="right_content">
            <h4>회원 정보 확인</h4>
            <table>
                <tr>
                    <th align="center" width="140">아아디</th>
                    <th align="center" width="140">이름</th>
                    <th align="center" width="80">예약</th>
                    <th align="center" width="80">후기</th>
                    <th align="center" width="140">등록일자</th>
                    <th align="center" width="50"></th>
                </tr>

                <tr v-if="!memberLists || (Array.isArray(memberLists) && memberLists.length === 0)">
                    <td colspan="4">
                        예약 내역이 없습니다!
                    </td>
                </tr>
                <tr v-else v-for="board in paginatedData" :key="board.memberNo" >
                    <td align="center">
                        {{ board.userId }}
                    </td>
                    <td align="center">
                        {{ board.userName }}
                    </td>
                    <td align="center" >
                        {{ board.bookingInfo.length }}
                    </td>
                    <td align="center" >
                        {{ board.review.length }}
                    </td>
                    <td align="center">
                        {{board.regDate.substring(0, 10)}}
                    </td>
                     <td align="center">
                        <button @click="checkDetail(board)"><v-icon>mdi-triangle-small-down</v-icon></button>
                    </td>
                </tr>
            </table>

            <div class="btn-cover">
                <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
                    이전
                </button>
                <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
                <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
                    다음
                </button>
            </div>
            <br><br>




            <div class="showDetails" v-show="showDetail">
                <hr>
                <v-btn color="black" text type="button" @click="closeDetail" class="closeBtn"> 상세 내용 닫기</v-btn>
                <br><br>
                <h4>예약 내역</h4>
                <table>
                <tr>
                    <th align="center" width="100">번호</th>
                    <th align="center" width="140">진행사항</th>
                    <th align="center" width="300">제목</th>
                    <th align="center" width="240">등록일자</th>
                </tr>

                <tr v-if="!boardList || (Array.isArray(boardList) && boardList.length === 0)">
                    <td colspan="4">
                        예약 내역이 없습니다!
                    </td>
                </tr>
                <tr v-else v-for="board in boardList" :key="board.bookingNo" >
                    <td align="center">
                        {{ board.bookingNo }}
                    </td>
                    <td align="center">
                        {{ board.process }}
                    </td>
                    <td align="center" >
                        <router-link :to="{ name: 'BookingReadPage',
                                            params: { bookingNo: board.bookingNo.toString() }}">
                            {{ board.id }} 님의 주문서입니다.
                        </router-link>
                    </td>
                    <td align="center">
                        {{ board.regDate}}
                    </td>
                </tr>
            </table>

            <div class="btn-cover">
                <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
                    이전
                </button>
                <span class="page-count">{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>
                <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
                    다음
                </button>
            </div>                


                <p>후기 내역</p>
                 <v-data-table :headers="headerTitle" :items="review"  class="elevation-0" >
                    
                    <template v-slot:[`item.reviewFile`]="{ item }" >
                        <img v-if="item.reviewFile != null" v-bind:src="require(`@/assets/review/${item.reviewFile}`)" height="230px"/>
                        <img v-if="item.reviewFile == null" v-bind:src="require(`@/assets/review/nullImg.png`)" height="230px"/>
                    </template>   

                    <template v-slot:[`item.actions`] ="{ item }" >
                    <v-icon
                        small
                        class="mr-2"
                        @click="editItem(item)"
                    >
                        mdi-pencil
                    </v-icon>
                    <v-icon
                        small
                        @click="deleteItem(item)"
                    >
                        mdi-delete
                    </v-icon>
                    </template>
                </v-data-table>
            </div>
        </div>
        
    </div>
</template>

<script>
    export default {
        name: 'ManagerPageCakeForm',
        props: {
            pageSize: {
                type: Number,
                required: false,
                default: 10
            },
            memberLists: {
                type: Array,
                required: true
            }
        },
        data () {
            return {
                pageNum: 0,
                bookingNo:'',
                id: (window.localStorage.getItem('id')),
                showDetail: false,
                 headerTitle: [
                { text:'no', value: 'reviewNo', width:'70px'},
                { text:'reviewFile', value: 'reviewFile', width:'70px'},
                { text: 'content', value: 'content', width: "350px" },
                { text: 'writer', value: 'id', width: "90px" },
                { text: 'date', value: 'regDate', width: "150px" },
                ],
                review:[],
                boardList:[]
            }
        },
        computed: {
            pageCount () {
                let listLeng = this.memberLists.length,
                    listSize = this.pageSize,
                    page = Math.floor(listLeng / listSize);
                if (listLeng % listSize > 0) page += 1
                return page;
            },
            paginatedData () {
                const start = this.pageNum * this.pageSize,
                        end = start + this.pageSize;
                return this.memberLists.slice(start, end);
                
            }
        },
        methods: {
            nextPage () {
            this.pageNum += 1;
            },
            prevPage () {
            this.pageNum -= 1;
            },
            checkDetail(board) {
                this.review = board.review
                this.boardList = board.bookingInfo
                this.showDetail = true
            },
            closeDetail() {
                this.showDetail = false
            }
        }
    }
</script>

<style scoped>
.myPageForm{
    display: grid;
    grid-template-columns: 150px 1000px;
}
.left_menu {
    width: 200px;
    border-right-width:3px; border-right-color:rgb(226, 154, 154);; border-right-style:dotted;
    padding: 3%;
}

.right_content {
    margin: 5% 0 0 10%;
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

table {
  width: 100%;
  border-collapse: collapse;
}
table th {
  font-size: 1.1rem;
}
table tr {
  height: 1rem;
  text-align: center;
  border-bottom: 1px solid #797979;
}
table tr:first-of-type {
  border-top: 2px solid #404040;
}
table tr td {
  padding: 1rem 0;
  font-size: 1rem;
}

table tr td a {
    text-decoration: none; 
    color: inherit;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}



</style>