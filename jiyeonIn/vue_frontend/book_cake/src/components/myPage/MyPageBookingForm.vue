<template>
    <div class="myPageForm">
        <h4>MY 페이지</h4>
        <br><br>
        <div class="left_menu">
            <ul>
                <li>
                    <router-link :to="{ name: 'MyPage'}">
                        <strong> 나의 정보 수정 </strong>
                    </router-link>
                </li>
                <br>
                <li>
                    <router-link :to="{ name: 'MyPageBooking'}">
                        <strong> 예약 내역 확인  </strong>
                    </router-link>
                </li>
                <br>
                <li>
                    <router-link :to="{ name: 'MyPageReview'}">
                        <strong> 후기 내역 확인  </strong>
                    </router-link>
                </li>
            </ul>
        </div>

        
        <div class="right_content">
            <h4>예약 내역 확인</h4>
            <br>
            <table>
                <tr>
                    <th align="center" width="100">번호</th>
                    <th align="center" width="140">진행사항</th>
                    <th align="center" width="300">제목</th>
                    <th align="center" width="240">등록일자</th>
                </tr>

                <tr v-if="!bookingIdLists || (Array.isArray(bookingIdLists) && bookingIdLists.length === 0)">
                    <td colspan="4">
                        예약 내역이 없습니다!
                    </td>
                </tr>
                <tr v-else v-for="board in paginatedData" :key="board.bookingNo" >
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
            
        </div>
        
    </div>
</template>

<script>
    export default {
        name: 'MyPageBookingForm',
        props: {
            bookingIdLists: {
                type: Array,
                required: true
            },
            pageSize: {
                type: Number,
                required: false,
                default: 10
            }
        },
        data () {
            return {
                pageNum: 0,
                bookingNo:'',

            }
        },
        computed: {
            pageCount () {
                let listLeng = this.bookingIdLists.length,
                    listSize = this.pageSize,
                    page = Math.floor(listLeng / listSize);
                if (listLeng % listSize > 0) page += 1
                return page;
            },
            paginatedData () {
                const start = this.pageNum * this.pageSize,
                        end = start + this.pageSize;
                return this.bookingIdLists.slice(start, end);
                
            }
        },
        methods: {
            nextPage () {
            this.pageNum += 1;
            },
            prevPage () {
            this.pageNum -= 1;
            }
        }
    }
</script>

<style scoped>
.myPageForm{
    display: grid;
    grid-template-columns: 150px 900px;
}
.left_menu {
    width: 200px;
    height: 500px;
    border-right-width:3px; border-right-color:rgb(226, 154, 154);; border-right-style:dotted;
    padding: 3%;
}

.right_content {
    margin: 5% 0 0 25%;
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