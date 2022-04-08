<template>

  <div>
    <div>
      {{id}}
    </div>

    <BeforePencilIcon @submit="onSubmit" :id="id"/>
  </div>
</template>

<script>
import {mapActions, mapState} from "vuex";
import BeforePencilIcon from "@/components/Item/BeforePencilIcon";
import axios from "axios";

export default {
  name: "PlanView",
  components: {BeforePencilIcon},
  props: {

  },
  data() {
    return {
      id: localStorage.getItem("session") || "",
    }
  },
  methods: {
    ...mapActions(['fetchLoginMember']),
    onSubmit(payload){
      console.log(payload + this.userId)
      let id = this.id;
      const {planName, planDate, placeName} = payload;
      console.log({planName, planDate, placeName, id})
      axios.post('http://localhost:7777/plan/makePlan', {planName, planDate, placeName, id})
          .then((res) => {
            console.log(res);
          })
          .catch((res) => {
            console.log(res.response.data.message);
          })
    }
  },
  computed: {
    ...mapState(['userPlans'])
  },
  created() {
    this.fetchLoginMember(this.id)
        .catch(() => {
          alert('오류')
        })
  }
}
</script>

<style scoped>

</style>