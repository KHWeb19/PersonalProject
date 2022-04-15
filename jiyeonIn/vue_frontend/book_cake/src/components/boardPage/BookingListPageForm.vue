<template>
    <div>
    <table>
            <tr>
                <th align="center" width="100">번호</th>
                <th align="center" width="140">진행사항</th>
                <th align="center" width="300">제목</th>
                <th align="center" width="240">등록일자</th>
            </tr>

            <tr>
                <td>
                    공지사항
                </td>
                <td>
                </td>
                <td>
                    <router-link :to="{ name: 'BeforeBooking'}">
                       <strong> 예약 전 필독 </strong>
                    </router-link>
                </td>
                <td>
                    2022.4.11 오전 10:00:00
                </td>
            </tr>
            <tr>
                 <td>
                    공지사항
                </td>
                <td>
                </td>
                <td>
                    <router-link :to="{ name: 'BeforeConfirm'}">
                        <strong> 예약 확정 전 필독</strong>
                    </router-link>
                </td>
                <td>
                    2022.4.11 오전 10:00:00
                </td>
            </tr>


            <tr v-if="!bookingLists || (Array.isArray(bookingLists) && bookingLists.length === 0)">
                <td colspan="4">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="board in paginatedData" :key="board.bookingNo">
                <td align="center">
                    {{ board.bookingNo }}
                </td>
                <td align="center">
                    {{ board.process }}
                </td>
                <td align="center" >
                    <router-link :to="{ name: 'BookingReadPage',
                                        params: { bookingNo: board.bookingNo.toString(), id: this.checkId}}" > 
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
</template>

<script>
    export default {
        name: 'BookingListPageForm',
        props: {
            bookingLists: {
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
                id: (window.localStorage.getItem('id')),
                checkId: (window.localStorage.getItem('id'))
            }
        },
        computed: {
            pageCount () {
                let listLeng = this.bookingLists.length,
                    listSize = this.pageSize,
                    page = Math.floor(listLeng / listSize);
                if (listLeng % listSize > 0) page += 1
                return page;
            },
            paginatedData () {
                const start = this.pageNum * this.pageSize,
                        end = start + this.pageSize;
                return this.bookingLists.slice(start, end);
                
            }
        },
        methods: {
            nextPage () {
            this.pageNum += 1;
            },
            prevPage () {
            this.pageNum -= 1;
            },
            checksomeID(bookingNo) {
                if(this.dbrAction != this.bookingLists[bookingNo].id && this.dbrAction != 'manager') {
                alert('해당 아이디만 읽을 수 있습니다!')
                this.$router.push({
                            name: 'BookingListPage'
                            })
                }
            }
        }
        

    }
</script>

<style scoped>
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