<template>
  <div>
    <div class="radio">
      <label>
        <input
          type="radio"
          value="now"
          name="sendType2"
          v-model="toggleSendType"
        />
      </label>
      <div class="input-group" v-show="sendType2">
        <div class="input-group-text">
          <p>나나나2</p>
        </div>
      </div>
    </div>

    <div class="radio">
      <label>
        <input
          type="radio"
          value="reserve"
          name="sendType"
          id="sendType"
          v-model="toggleSendType"
        />
      </label>
      <div class="input-group" v-show="sendType">
        <div class="input-group-text">
          <p>나나나</p>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "TestForm",
  data: function () {
    return {
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
}
</script>
<style></style>