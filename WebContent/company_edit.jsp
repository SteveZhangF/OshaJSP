<jsp:useBean id="company" scope="request" class="bean.user.data.Company" />
<form class="form-horizontal" action="<%=application.getContextPath()%>/company">
    <fieldset>
      <div id="legend" class="">
        <legend class="">Company Information</legend>
      </div>
      <input type="hidden" name="action" value='<%=request.getAttribute("action") %>'/>
      <input type="hidden" name="company_id" value='<jsp:getProperty property="uuid" name="company"/>'/>
    <div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="company_name">Company Name:</label>
          <div class="controls">
            <input type="text" placeholder="Company name" class="input-xlarge" id="company_name" name="company_name" value='<jsp:getProperty property="company_name" name="company"/>'>
            <p class="help-block">please type the company name</p>
          </div>
        </div><div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="company_address">Address:</label>
          <div class="controls">
            <input type="text" placeholder="Address" class="input-xlarge" id="company_address" name="company_address" value='<jsp:getProperty property="company_address" name="company"/>'>
            <p class="help-block">please type address</p>
          </div>
        </div>

    <div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="company_phone">Phone Number:</label>
          <div class="controls">
            <input type="text" placeholder="Phone Number" class="input-xlarge" id="company_phone" name="company_phone" value='<jsp:getProperty property="company_phone" name="company"/>'>
            <p class="help-block">please type the phone number</p>
          </div>
        </div>
    </fieldset>
  </form>
