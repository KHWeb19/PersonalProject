<template>
    <body>
      <v-container>
      <form>
        <h2>진료 예약 내역 확인 및 취소</h2><br>
         <table>
            <tr style="text--white">
                <th align="center" width="200">예약번호</th>
                <th align="center" width="240">날짜</th>
                <th align="center" width="240">시간</th>
                <th align="center" width="240">회원정보</th>
                <th align="center" width="240">의사정보</th>
            </tr>
            <tr v-if="!appointments || (Array.isArray(appointments) && appointments.length === 0)">
                <td colspan="5">
                    No Values
                </td>
            </tr>
                <tr v-else v-for="appointment in appointments" :key="appointment.aptNo">
                  <td align="center">
                    {{ appointment.aptNo }}
                  </td>
                  <td align="center">
                    {{ appointment.date }}
                  </td>
                  <td align="center">
                    {{ appointment.time }}
                  </td>
                  <td align="right">
                    {{ appointment.memberNo }}
                  </td>
                  <td align="center">
                    {{ appointment.doctorNo }}
                  </td>
                </tr>
        </table><br><br><br><br><br>
      </form>
      </v-container>
</body>
</template>

<script>
export default {
  name: 'CheckAppointment',
  props: {
    appointments: {
      type: Array,
      required: true
    }
  }
}
</script>

<style scoped>
a { text-decoration: none; }
button { width: 300px; height: 60px; background-color: gray; }
#btn { text-align: right; font-size: 18px;}
#btnRegisterPage { background:navy;}
table { font-size: 18px; border-top: 1px solid navy; border-collapse: collapse;}
th { color: white; padding: 10px; background-color: navy;}
td { padding: 10px; text-align: center; border-bottom: 1px solid gray;}
</style>
