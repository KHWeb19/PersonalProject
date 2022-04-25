<template>
  <div class="memberlist">
    <div class="container">
      <div class="row">
        <div class="col-sm-4">
          <header class="memberlist-header">
            <h2>회원관리</h2>
          </header>

          <table class="memberlist-table">
            <thead>
              <tr>
                <th scope="col" align="center" width="50">번호</th>
                <th scope="col" align="center" width="80">아이디</th>
                <th scope="col" align="center" width="150">닉네임</th>
                <th scope="col" align="center" width="60">가입일자</th>
              </tr>
            </thead>
            <tbody>
              <tr
                v-if="
                  !members || (Array.isArray(members) && members.length === 0)
                "
              >
                <td align="center" colspan="7">등록된회원없음p(ㅠ.ㅠ)q</td>
              </tr>
              <tr v-else v-for="member in paginatedData" :key="member.memberNo">
                <td align="center">{{ member.memberNo }}</td>
                <td align="left">
                  <router-link
                    :to="{
                      name: 'MemberReadPage',
                      params: { memberNo: member.memberNo.toString() },
                    }"
                  >
                    {{ member.userId }}
                  </router-link>
                </td>
                <td align="center">{{ member.userName }}</td>
                <td align="center">
                  {{ $moment(member.regDate).format("YYYY-MM-DD") }}
                </td>
              </tr>
            </tbody>
          </table>

          <div class="pagination">
            <button
              @click="prevPage"
              :disabled="pageNum === 0"
              class="page-control page-prev"
              type="button"
              aria-label="이전페이지로 이동"
            >
              <i class="ic-chevron"></i>
            </button>
            <ol class="page-list">
              <li class="page-item is-active">
                <a href="/">{{ pageNum + 1 }} / {{ pageCount }}</a>
              </li>
            </ol>
            <button
              @click="nextPage"
              :disabled="pageNum >= pageCount - 1"
              class="page-control page-next"
              type="button"
              aria-label="다음페이지로 이동"
            >
              <i class="ic-chevron"></i>
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import VueMoment from "vue-moment"
import Vue from "vue"
Vue.use(VueMoment)
export default {
  name: "MemberList",
  props: {
    members: {
      type: Array,
    },
    listArray: {
      type: Array,
      required: true,
    },
    pageSize: {
      type: Number,
      required: false,
      default: 7,
    },
  },
  data() {
    return {
      pageNum: 0,
    }
  },
  methods: {
    nextPage() {
      this.pageNum += 1
    },
    prevPage() {
      this.pageNum -= 1
    },
  },
  computed: {
    pageCount() {
      let listLeng = this.listArray.length,
        listSize = this.pageSize,
        page = Math.floor(listLeng / listSize)

      if (listLeng % listSize > 0) page += 1
      return page
    },
    paginatedData() {
      const start = this.pageNum * this.pageSize,
        end = start + this.pageSize
      return this.listArray.slice(start, end)
    },
  },
}
</script>
<style lang="scss">
@import "~@/assets/scss/layout/member-list";
@import "~@/assets/scss/components/pagination";
</style>
