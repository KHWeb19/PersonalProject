<template>
    <div>
    <table >
      <tr>
          <th align="center" width="80">시</th>
          <th align="center" width="80">구</th>
          <th align="center" width="80">동</th>
          <th align="center" width="300">주소</th>
          <th align="center" width="150">상호명</th>
      </tr>
      <tr v-if="!businessMembers || (Array.isArray(businessMembers) && businessMembers.length === 0)">
          <td align="center" colspan="4">
              현재 사업자 회원이 없습니다!
          </td>
      </tr>
      <tr v-else v-for="businessMember in businessMembers" :key=" businessMember.memberNo">
          <td align="center"> {{ memberNo.city }} </td>
          <td align="center"> {{ memberNo.dong }} </td>
          <td align="center"> {{ memberNo.adress }} </td>
          <td align="center"> {{ memberNo.storeName }} </td>
      </tr>
  </table>        
    </div>
</template>

<script>
export default {
    name: "LookBusinessMemberForm.vue",
    props: {
        businessMember: {
            type: Array
        },
        memberNo: {
          type: String,
          required: true
        }
    }
}
</script>

<style scoped>
.td {
  margin: 20px;
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