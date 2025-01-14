/**
 * Copyright Apr 22, 2021, Quicko.
 * All Rights Reserved.
 * Confidential Information
 * Authored by Manav Darji
 */
package in.co.sandbox.api.client.kyc;

import java.io.IOException;

import org.json.JSONObject;

import in.co.sandbox.api.auth.ApiSessionCredentials;
import in.co.sandbox.api.beans.ApiResponse;
import in.co.sandbox.api.client.RestClient;
import in.co.sandbox.api.exception.SandboxException;
import in.co.sandbox.api.types.ENDPOINTS;
import in.co.sandbox.api.types.ENDPOINTS.Environment;

// TODO: Auto-generated Javadoc
/**
 * The Class BankClient.
 */
public class BankClient extends RestClient
{

	/**
	 * Instantiates a new bank client.
	 *
	 * @param sessionCredentials
	 *            the session credentials
	 * @param enableDebugLog
	 *            the enable debug log
	 */
	public BankClient(final ApiSessionCredentials sessionCredentials, final boolean enableDebugLog)
	{
		super(sessionCredentials, enableDebugLog);
	}

	/**
	 * Verify bank account.
	 *
	 * @param ifsc
	 *            the ifsc
	 * @param accountNumber
	 *            the account number
	 * @param name
	 *            the name
	 * @param mobile
	 *            the mobile
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject verifyBankAccount(final String ifsc, final String accountNumber, final String name,
	        final String mobile) throws SandboxException
	{

		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.VERIFY_BANK_ACCOUNT,
			        Environment.get(sessionCredentials.getApiKey()), ifsc, accountNumber, name, mobile));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}

	}

	/**
	 * Verify bank account penniless.
	 *
	 * @param ifsc
	 *            the ifsc
	 * @param accountNumber
	 *            the account number
	 * @param name
	 *            the name
	 * @param mobile
	 *            the mobile
	 * @return the JSON object
	 * @throws SandboxException
	 *             the sandbox exception
	 */
	public JSONObject verifyBankAccountPenniless(final String ifsc, final String accountNumber, final String name,
	        final String mobile) throws SandboxException
	{

		try
		{
			ApiResponse response = super.get(ENDPOINTS.build(ENDPOINTS.URL.VERIFY_BANK_ACCOUNT_PENNILESS,
			        Environment.get(sessionCredentials.getApiKey()), ifsc, accountNumber, name, mobile));

			return response.get("data");
		}
		catch (final IOException e)
		{
			throw new SandboxException("Internal Server Error", 500);
		}

	}

}
